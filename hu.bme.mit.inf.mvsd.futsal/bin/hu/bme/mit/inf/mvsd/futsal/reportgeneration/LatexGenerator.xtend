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
		«generateMatch(match)»
		«generateTeams(match)»
		«generateEvents(match)»
		«generateResult(match)»
	'''
	
	def generateMatch(Match match) '''
	
	\section{A mérkõzés adatai}
	
	\begin{itemize}
	\item\textbf{Bajnokság:} «notNull(match.chanmpionship)»
	\item\textbf{Mérkõzés kódja:} «match.code»
	\item\textbf{Idõpontja:} «notNull(match.date)»
	\item\textbf{Helyszín:} «notNull(match.location.name)» («match.location.address»)
	\item\textbf{Évad:} «notNull(match.season)»
	\item\textbf{Forduló:} «match.round»
	\item\textbf{Szakág:} «notNull(match.section)»
	\item\textbf{Korosztály:} «notNull(match.ageGroup)»
	\item\textbf{Típus:} «notNull(match.category)»
	\end{itemize}
	
	\subsection{Játékvezetõ}
	
	«generateReferee(match.referee1)»
	
	\subsection{Asszisztensek}
	
	«generateReferee(match.referee2)»
	
	«generateReferee(match.referee3)»
	
	\subsection{Ellenõr}
	
	«generateSupervisor(match.supervisor)»
	
	'''
	
	
	def generateReferee(Referee referee) {
		if (referee == null || referee.name == null)
			return "-";
		'''
		
		\subsubsection{«referee.name»}
		
		\begin{itemize}
		\item\textbf{Kód:} «referee.identifier»
		\item\textbf{Született:} «notNull(referee.dateOfBirth)»
		\item\textbf{Cím:} «notNull(referee.address)»
		\end{itemize}
		'''
	}

	def generateSupervisor(Supervisor supervisor) {
		if (supervisor == null || supervisor.name == null)
			return "-";
		'''
		
		\subsubsection{«supervisor.name»}
		
		\begin{itemize}
		\item\textbf{Kód:} «supervisor.identifier»
		\item\textbf{Született:} «notNull(supervisor.dateOfBirth)»
		\item\textbf{Cím:} «notNull(supervisor.address)»
		\end{itemize}
		'''
	}
	

	def generateTeams(Match match) '''
	
	\section{Csapatok}
	
	«generateTeam(match.team1)»
	
	«generateTeam(match.team2)»
	'''
	
	def generateTeam(Team team) '''
	
	\subsection(«team.name»)
	
	\noindent\textbf{Csapatkapitány:} «team.captain.name» («team.captain.squadNumber»)
	
	\subsubsection{Kezdõjátékosok}
	
	«generatePlayer(team.goalKeeper)»
    «FOR player : team.fieldPlayers»
    «generatePlayer(player)»
    «ENDFOR»
    
    \subsubsection{Cserejátékosok}
    
    «FOR player : team.subtitutePlayers»
    «generatePlayer(player)»
    «ENDFOR»
    «FOR player : team.subtituteGoalKeepers»
    «generatePlayer(player)»
    «ENDFOR»
    
    \subsubsection{A kispadon helyet foglaló személyek}
    
    «FOR crew : team.bench»
    «generateCrew(crew)»
    «ENDFOR»
	
	'''
	
	def generatePlayer(Player player) '''
		
		\noindent\textbf{«player.name» «if (player instanceof GoalKeeper) "\textit{(kapus)}"»}
		
		\begin{itemize}
		\item\textbf{Mezszám:} «player.squadNumber»
		\item\textbf{Szerzõdésszám:} «player.licenceNumber»
		\item\textbf{Született:} «notNull(player.dateOfBirth)»
		\item\textbf{Cím:} «notNull(player.address)»
		\end{itemize}
		
	'''

	def generateCrew(Crew crew) '''
		
		\noindent\textbf{«crew.name»}
		
		\begin{itemize}
		\item\textbf{Pozíció:} «GeneratorHelper::roleToString(crew.role)»
		\item\textbf{Szerzõdésszám:} «crew.licenceNumber»
		\item\textbf{Született:} «notNull(crew.dateOfBirth)»
		\item\textbf{Cím:} «notNull(crew.address)»
		\end{itemize}
	'''


	def generateEvents(Match match) '''
		
		\section{A mérkõzés részletes jegyzõkönyve}
		
		«generateEventFlow(match)»
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
			case 1 : "\\subsection{Elsõ félidõ}"
			case 2 : "\\subsection{Második félidõ}"
			case 3 : "\\subsection{Hosszabbítás elsõ félideje}"
			case 4 : "\\subsection{Hosszabbítás második félideje}"
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
		
		\noindent\textbf{«GeneratorHelper::timeToString(goal.time, true)»:} «goal.player.name» («goal.player.squadNumber») «if (goal.player.team != goal.scorerTeam) "öngólt" else "gólt"» rúg, pontot szerez a(z) «goal.scorerTeam.name».
		
	'''
	
	def generateFault(Fault fault) '''
		
		\noindent\textbf{«GeneratorHelper::timeToString(fault.time, true)»:} «fault.player.name» («fault.player.squadNumber») szabálytalankodik, büntetése «switch (fault.type) { case FaultType::PENALTY : "szabadrúgás a másik csapatnak" case FaultType::YELLOW_CARD : "sárga lap" case FaultType::RED_CARD : "piros lap" default : "" }».
	'''
	
	def generateSubstitution(Substitution substitution) '''
		
		\noindent\textbf{«GeneratorHelper::timeToString(substitution.time, true)»:} Csere a(z) «substitution.substitute.team.name» csapatnál, «substitution.substitute.name» («substitution.substitute.squadNumber») játékba áll «substitution.instead.name» («substitution.instead.squadNumber») helyett.
	'''
	
	def generateTimeout(TimeOut timeout) '''
		
		\noindent\textbf{«GeneratorHelper::timeToString(timeout.time, true)»:} A(z) «timeout.team.name» csapat idõt kér.
	'''
	
	def generateResult(Match match) '''
		
		\section{Összefoglalás}
		
		\subsection{Végeredmény}
		
		\noindent\textbf{«match.team1.name»:} «GeneratorHelper::calculateScore(match.team1, false)»
		
		\noindent\textbf{«match.team2.name»:} «GeneratorHelper::calculateScore(match.team2, false)»
		
		\subsection{Félidõben}
		
		\noindent\textbf{«match.team1.name»:} «GeneratorHelper::calculateScore(match.team1, true)»
		
		\noindent\textbf{«match.team2.name»:} «GeneratorHelper::calculateScore(match.team2, true)»
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