package hu.bme.mit.inf.mvsd.futsal.reportgeneration

import hu.bme.mit.inf.mvsd.domain.generated.futsal.Match
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Team
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Referee
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Supervisor
import hu.bme.mit.inf.mvsd.domain.generated.futsal.GoalKeeper
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Player
import java.util.Date
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Crew
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Event
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Goal
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Fault
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Substitution
import hu.bme.mit.inf.mvsd.domain.generated.futsal.TimeOut
import hu.bme.mit.inf.mvsd.domain.generated.futsal.FaultType;

class LatexGenerator {
	def generate(Match match, String path) {
		GeneratorHelper::writeHtmlFile(path, generateLatex(match).toString);
	}
	
	def generateLatex(Match match) '''
		�generateMatch(match)�
		�generateTeams(match)�
		�generateEvents(match)�
		�generateResult(match)�
	'''
	
	def generateMatch(Match match) '''
	
	\section{A m�rk�z�s adatai}
	
	\begin{itemize}
	\item\textbf{Bajnoks�g:} �notNull(match.chanmpionship)�
	\item\textbf{M�rk�z�s k�dja:} �match.code�
	\item\textbf{Id�pontja:} �notNull(match.date)�
	\item\textbf{Helysz�n:} �notNull(match.location.name)� (�match.location.address�)
	\item\textbf{�vad:} �notNull(match.season)�
	\item\textbf{Fordul�:} �match.round�
	\item\textbf{Szak�g:} �notNull(match.section)�
	\item\textbf{Koroszt�ly:} �notNull(match.ageGroup)�
	\item\textbf{T�pus:} �notNull(match.category)�
	\end{itemize}
	
	\subsection{J�t�kvezet�}
	
	�generateReferee(match.referee1)�
	
	\subsection{Asszisztensek}
	
	�generateReferee(match.referee2)�
	
	�generateReferee(match.referee3)�
	
	\subsection{Ellen�r}
	
	�generateSupervisor(match.supervisor)�
	
	'''
	
	
	def generateReferee(Referee referee) {
		if (referee == null || referee.name == null)
			return "-";
		'''
		
		\subsubsection{�referee.name�}
		
		\begin{itemize}
		\item\textbf{K�d:} �referee.identifier�
		\item\textbf{Sz�letett:} �notNull(referee.dateOfBirth)�
		\item\textbf{C�m:} �notNull(referee.address)�
		\end{itemize}
		'''
	}

	def generateSupervisor(Supervisor supervisor) {
		if (supervisor == null || supervisor.name == null)
			return "-";
		'''
		
		\subsubsection{�supervisor.name�}
		
		\begin{itemize}
		\item\textbf{K�d:} �supervisor.identifier�
		\item\textbf{Sz�letett:} �notNull(supervisor.dateOfBirth)�
		\item\textbf{C�m:} �notNull(supervisor.address)�
		\end{itemize}
		'''
	}
	

	def generateTeams(Match match) '''
	
	\section{Csapatok}
	
	�generateTeam(match.team1)�
	
	�generateTeam(match.team2)�
	'''
	
	def generateTeam(Team team) '''
	
	\subsection(�team.name�)
	
	\noindent\textbf{Csapatkapit�ny:} �team.captain.name� (�team.captain.squadNumber�)
	
	\subsubsection{Kezd�j�t�kosok}
	
	�generatePlayer(team.goalKeeper)�
    �FOR player : team.fieldPlayers�
    �generatePlayer(player)�
    �ENDFOR�
    
    \subsubsection{Cserej�t�kosok}
    
    �FOR player : team.subtitutePlayers�
    �generatePlayer(player)�
    �ENDFOR�
    �FOR player : team.subtituteGoalKeepers�
    �generatePlayer(player)�
    �ENDFOR�
    
    \subsubsection{A kispadon helyet foglal� szem�lyek}
    
    �FOR crew : team.bench�
    �generateCrew(crew)�
    �ENDFOR�
	
	'''
	
	def generatePlayer(Player player) '''
		
		\noindent\textbf{�player.name� �if (player instanceof GoalKeeper) "\textit{(kapus)}"�}
		
		\begin{itemize}
		\item\textbf{Mezsz�m:} �player.squadNumber�
		\item\textbf{Szerz�d�ssz�m:} �player.licenceNumber�
		\item\textbf{Sz�letett:} �notNull(player.dateOfBirth)�
		\item\textbf{C�m:} �notNull(player.address)�
		\end{itemize}
		
	'''

	def generateCrew(Crew crew) '''
		
		\noindent\textbf{�crew.name�}
		
		\begin{itemize}
		\item\textbf{Poz�ci�:} �GeneratorHelper::roleToString(crew.role)�
		\item\textbf{Szerz�d�ssz�m:} �crew.licenceNumber�
		\item\textbf{Sz�letett:} �notNull(crew.dateOfBirth)�
		\item\textbf{C�m:} �notNull(crew.address)�
		\end{itemize}
	'''


	def generateEvents(Match match) '''
		
		\section{A m�rk�z�s r�szletes jegyz�k�nyve}
		
		�generateEventFlow(match)�
	'''
	
	def generateEventFlow(Match match) {
		var target = -1;
		var halftime = 0;
		var ret = new StringBuilder();
		var current = match.firstEvent;
		
		while(current != null)
		{
			if (current.time > target) {
				halftime = halftime + 1;
				target = moveTarget(target);
				ret.append(generateHalfTimeHeader(halftime));
			}
			ret.append(generateEvent(current));
			current = current.next;
		}
		return ret.toString;
	}

	def int moveTarget(int i) {
		if (i == -1) return 1200;
		if (i == 1200) return 2400;
		if (i == 2400) return 2700;
		return 3000;
	}

	def generateHalfTimeHeader(int i) {
		return switch (i) {
			case 1 : "\\subsection{Els� f�lid�}"
			case 2 : "\\subsection{M�sodik f�lid�}"
			case 3 : "\\subsection{Hosszabb�t�s els� f�lideje}"
			case 4 : "\\subsection{Hosszabb�t�s m�sodik f�lideje}"
			default : ""
		}
	}

	def generateEvent(Event event) {
		if (event instanceof Goal) return generateGoal(event as Goal);
		if (event instanceof Fault) return generateFault(event as Fault);
		if (event instanceof Substitution) return generateSubstitution(event as Substitution);
		if (event instanceof TimeOut) return generateTimeout(event as TimeOut);
		return "";
	}
	
	def generateGoal(Goal goal) '''
		
		\noindent\textbf{�GeneratorHelper::timeToString(goal.time, true)�:} �goal.player.name� (�goal.player.squadNumber�) �if (goal.player.team != goal.scorerTeam) "�ng�lt" else "g�lt"� r�g, pontot szerez a(z) �goal.scorerTeam.name�.
		
	'''
	
	def generateFault(Fault fault) '''
		
		\noindent\textbf{�GeneratorHelper::timeToString(fault.time, true)�:} �fault.player.name� (�fault.player.squadNumber�) szab�lytalankodik, b�ntet�se �switch (fault.type) { case FaultType::PENALTY : "szabadr�g�s a m�sik csapatnak" case FaultType::YELLOW_CARD : "s�rga lap" case FaultType::RED_CARD : "piros lap" default : "" }�.
	'''
	
	def generateSubstitution(Substitution substitution) '''
		
		\noindent\textbf{�GeneratorHelper::timeToString(substitution.time, true)�:} Csere a(z) �substitution.substitute.team.name� csapatn�l, �substitution.substitute.name� (�substitution.substitute.squadNumber�) j�t�kba �ll �substitution.instead.name� (�substitution.instead.squadNumber�) helyett.
	'''
	
	def generateTimeout(TimeOut timeout) '''
		
		\noindent\textbf{�GeneratorHelper::timeToString(timeout.time, true)�:} A(z) �timeout.team.name� csapat id�t k�r.
	'''
	
	def generateResult(Match match) '''
		
		\section{�sszefoglal�s}
		
		\subsection{V�geredm�ny}
		
		\noindent\textbf{�match.team1.name�:} �GeneratorHelper::calculateScore(match.team1, false)�
		
		\noindent\textbf{�match.team2.name�:} �GeneratorHelper::calculateScore(match.team2, false)�
		
		\subsection{F�lid�ben}
		
		\noindent\textbf{�match.team1.name�:} �GeneratorHelper::calculateScore(match.team1, true)�
		
		\noindent\textbf{�match.team2.name�:} �GeneratorHelper::calculateScore(match.team2, true)�
	'''
	
	def notNull(String string) {
		return if (string == null)
			"-"
		else
			string;
	}
	
	def notNull(Date date) {
		return if (date == null)
			"-"
		else
			date.toLocaleString();
	}

}