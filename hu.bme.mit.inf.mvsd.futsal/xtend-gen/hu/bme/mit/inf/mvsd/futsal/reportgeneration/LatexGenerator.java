package hu.bme.mit.inf.mvsd.futsal.reportgeneration;

import com.google.common.base.Objects;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Crew;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.CrewRole;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Event;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Fault;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.FaultType;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Goal;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.GoalKeeper;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Match;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Pitch;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Player;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Referee;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Substitution;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Supervisor;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Team;
import hu.bme.mit.inf.mvsd.domain.generated.futsal.TimeOut;
import hu.bme.mit.inf.mvsd.futsal.reportgeneration.GeneratorHelper;
import java.util.Date;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class LatexGenerator {
  public void generate(final Match match, final String path) {
    try {
      CharSequence _generateLatex = this.generateLatex(match);
      String _string = _generateLatex.toString();
      GeneratorHelper.writeHtmlFile(path, _string);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public CharSequence generateLatex(final Match match) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generateMatch = this.generateMatch(match);
    _builder.append(_generateMatch, "");
    _builder.newLineIfNotEmpty();
    CharSequence _generateTeams = this.generateTeams(match);
    _builder.append(_generateTeams, "");
    _builder.newLineIfNotEmpty();
    CharSequence _generateEvents = this.generateEvents(match);
    _builder.append(_generateEvents, "");
    _builder.newLineIfNotEmpty();
    CharSequence _generateResult = this.generateResult(match);
    _builder.append(_generateResult, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateMatch(final Match match) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\\section{A m\u00E9rk\u0151z\u00E9s adatai}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\begin{itemize}");
    _builder.newLine();
    _builder.append("\\item\\textbf{Bajnoks\u00E1g:} ");
    String _chanmpionship = match.getChanmpionship();
    String _notNull = this.notNull(_chanmpionship);
    _builder.append(_notNull, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\item\\textbf{M\u00E9rk\u0151z\u00E9s k\u00F3dja:} ");
    int _code = match.getCode();
    _builder.append(_code, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\item\\textbf{Id\u0151pontja:} ");
    Date _date = match.getDate();
    String _notNull_1 = this.notNull(_date);
    _builder.append(_notNull_1, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\item\\textbf{Helysz\u00EDn:} ");
    Pitch _location = match.getLocation();
    String _name = _location.getName();
    String _notNull_2 = this.notNull(_name);
    _builder.append(_notNull_2, "");
    _builder.append(" (");
    Pitch _location_1 = match.getLocation();
    String _address = _location_1.getAddress();
    _builder.append(_address, "");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("\\item\\textbf{\u00C9vad:} ");
    String _season = match.getSeason();
    String _notNull_3 = this.notNull(_season);
    _builder.append(_notNull_3, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\item\\textbf{Fordul\u00F3:} ");
    int _round = match.getRound();
    _builder.append(_round, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\item\\textbf{Szak\u00E1g:} ");
    String _section = match.getSection();
    String _notNull_4 = this.notNull(_section);
    _builder.append(_notNull_4, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\item\\textbf{Koroszt\u00E1ly:} ");
    String _ageGroup = match.getAgeGroup();
    String _notNull_5 = this.notNull(_ageGroup);
    _builder.append(_notNull_5, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\item\\textbf{T\u00EDpus:} ");
    String _category = match.getCategory();
    String _notNull_6 = this.notNull(_category);
    _builder.append(_notNull_6, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\end{itemize}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\subsection{J\u00E1t\u00E9kvezet\u0151}");
    _builder.newLine();
    _builder.newLine();
    Referee _referee1 = match.getReferee1();
    String _generateReferee = this.generateReferee(_referee1);
    _builder.append(_generateReferee, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\\subsection{Asszisztensek}");
    _builder.newLine();
    _builder.newLine();
    Referee _referee2 = match.getReferee2();
    String _generateReferee_1 = this.generateReferee(_referee2);
    _builder.append(_generateReferee_1, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    Referee _referee3 = match.getReferee3();
    String _generateReferee_2 = this.generateReferee(_referee3);
    _builder.append(_generateReferee_2, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\\subsection{Ellen\u0151r}");
    _builder.newLine();
    _builder.newLine();
    Supervisor _supervisor = match.getSupervisor();
    String _generateSupervisor = this.generateSupervisor(_supervisor);
    _builder.append(_generateSupervisor, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public String generateReferee(final Referee referee) {
    String _xblockexpression = null;
    {
      boolean _or = false;
      boolean _equals = Objects.equal(referee, null);
      if (_equals) {
        _or = true;
      } else {
        String _name = referee.getName();
        boolean _equals_1 = Objects.equal(_name, null);
        _or = (_equals || _equals_1);
      }
      if (_or) {
        return "-";
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("\\subsubsection{");
      String _name_1 = referee.getName();
      _builder.append(_name_1, "");
      _builder.append("}");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\\begin{itemize}");
      _builder.newLine();
      _builder.append("\\item\\textbf{K\u00F3d:} ");
      int _identifier = referee.getIdentifier();
      _builder.append(_identifier, "");
      _builder.newLineIfNotEmpty();
      _builder.append("\\item\\textbf{Sz\u00FCletett:} ");
      Date _dateOfBirth = referee.getDateOfBirth();
      String _notNull = this.notNull(_dateOfBirth);
      _builder.append(_notNull, "");
      _builder.newLineIfNotEmpty();
      _builder.append("\\item\\textbf{C\u00EDm:} ");
      String _address = referee.getAddress();
      String _notNull_1 = this.notNull(_address);
      _builder.append(_notNull_1, "");
      _builder.newLineIfNotEmpty();
      _builder.append("\\end{itemize}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  public String generateSupervisor(final Supervisor supervisor) {
    String _xblockexpression = null;
    {
      boolean _or = false;
      boolean _equals = Objects.equal(supervisor, null);
      if (_equals) {
        _or = true;
      } else {
        String _name = supervisor.getName();
        boolean _equals_1 = Objects.equal(_name, null);
        _or = (_equals || _equals_1);
      }
      if (_or) {
        return "-";
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append("\\subsubsection{");
      String _name_1 = supervisor.getName();
      _builder.append(_name_1, "");
      _builder.append("}");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\\begin{itemize}");
      _builder.newLine();
      _builder.append("\\item\\textbf{K\u00F3d:} ");
      int _identifier = supervisor.getIdentifier();
      _builder.append(_identifier, "");
      _builder.newLineIfNotEmpty();
      _builder.append("\\item\\textbf{Sz\u00FCletett:} ");
      Date _dateOfBirth = supervisor.getDateOfBirth();
      String _notNull = this.notNull(_dateOfBirth);
      _builder.append(_notNull, "");
      _builder.newLineIfNotEmpty();
      _builder.append("\\item\\textbf{C\u00EDm:} ");
      String _address = supervisor.getAddress();
      String _notNull_1 = this.notNull(_address);
      _builder.append(_notNull_1, "");
      _builder.newLineIfNotEmpty();
      _builder.append("\\end{itemize}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  public CharSequence generateTeams(final Match match) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\\section{Csapatok}");
    _builder.newLine();
    _builder.newLine();
    Team _team1 = match.getTeam1();
    CharSequence _generateTeam = this.generateTeam(_team1);
    _builder.append(_generateTeam, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    Team _team2 = match.getTeam2();
    CharSequence _generateTeam_1 = this.generateTeam(_team2);
    _builder.append(_generateTeam_1, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateTeam(final Team team) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\\subsection(");
    String _name = team.getName();
    _builder.append(_name, "");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\\noindent\\textbf{Csapatkapit\u00E1ny:} ");
    Player _captain = team.getCaptain();
    String _name_1 = _captain.getName();
    _builder.append(_name_1, "");
    _builder.append(" (");
    Player _captain_1 = team.getCaptain();
    int _squadNumber = _captain_1.getSquadNumber();
    _builder.append(_squadNumber, "");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\\subsubsection{Kezd\u0151j\u00E1t\u00E9kosok}");
    _builder.newLine();
    _builder.newLine();
    GoalKeeper _goalKeeper = team.getGoalKeeper();
    CharSequence _generatePlayer = this.generatePlayer(_goalKeeper);
    _builder.append(_generatePlayer, "");
    _builder.newLineIfNotEmpty();
    {
      EList<Player> _fieldPlayers = team.getFieldPlayers();
      for(final Player player : _fieldPlayers) {
        _builder.append("    ");
        CharSequence _generatePlayer_1 = this.generatePlayer(player);
        _builder.append(_generatePlayer_1, "    ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\\subsubsection{Cserej\u00E1t\u00E9kosok}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    {
      EList<Player> _subtitutePlayers = team.getSubtitutePlayers();
      for(final Player player_1 : _subtitutePlayers) {
        _builder.append("    ");
        CharSequence _generatePlayer_2 = this.generatePlayer(player_1);
        _builder.append(_generatePlayer_2, "    ");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<GoalKeeper> _subtituteGoalKeepers = team.getSubtituteGoalKeepers();
      for(final GoalKeeper player_2 : _subtituteGoalKeepers) {
        _builder.append("    ");
        CharSequence _generatePlayer_3 = this.generatePlayer(player_2);
        _builder.append(_generatePlayer_3, "    ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\\subsubsection{A kispadon helyet foglal\u00F3 szem\u00E9lyek}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    {
      EList<Crew> _bench = team.getBench();
      for(final Crew crew : _bench) {
        _builder.append("    ");
        CharSequence _generateCrew = this.generateCrew(crew);
        _builder.append(_generateCrew, "    ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generatePlayer(final Player player) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\\noindent\\textbf{");
    String _name = player.getName();
    _builder.append(_name, "");
    _builder.append(" ");
    String _xifexpression = null;
    if ((player instanceof GoalKeeper)) {
      _xifexpression = "\textit{(kapus)}";
    }
    _builder.append(_xifexpression, "");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\\begin{itemize}");
    _builder.newLine();
    _builder.append("\\item\\textbf{Mezsz\u00E1m:} ");
    int _squadNumber = player.getSquadNumber();
    _builder.append(_squadNumber, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\item\\textbf{Szerz\u0151d\u00E9ssz\u00E1m:} ");
    int _licenceNumber = player.getLicenceNumber();
    _builder.append(_licenceNumber, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\item\\textbf{Sz\u00FCletett:} ");
    Date _dateOfBirth = player.getDateOfBirth();
    String _notNull = this.notNull(_dateOfBirth);
    _builder.append(_notNull, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\item\\textbf{C\u00EDm:} ");
    String _address = player.getAddress();
    String _notNull_1 = this.notNull(_address);
    _builder.append(_notNull_1, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\end{itemize}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateCrew(final Crew crew) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\\noindent\\textbf{");
    String _name = crew.getName();
    _builder.append(_name, "");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\\begin{itemize}");
    _builder.newLine();
    _builder.append("\\item\\textbf{Poz\u00EDci\u00F3:} ");
    CrewRole _role = crew.getRole();
    String _roleToString = GeneratorHelper.roleToString(_role);
    _builder.append(_roleToString, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\item\\textbf{Szerz\u0151d\u00E9ssz\u00E1m:} ");
    int _licenceNumber = crew.getLicenceNumber();
    _builder.append(_licenceNumber, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\item\\textbf{Sz\u00FCletett:} ");
    Date _dateOfBirth = crew.getDateOfBirth();
    String _notNull = this.notNull(_dateOfBirth);
    _builder.append(_notNull, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\item\\textbf{C\u00EDm:} ");
    String _address = crew.getAddress();
    String _notNull_1 = this.notNull(_address);
    _builder.append(_notNull_1, "");
    _builder.newLineIfNotEmpty();
    _builder.append("\\end{itemize}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateEvents(final Match match) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\\section{A m\u00E9rk\u0151z\u00E9s r\u00E9szletes jegyz\u0151k\u00F6nyve}");
    _builder.newLine();
    _builder.newLine();
    String _generateEventFlow = this.generateEventFlow(match);
    _builder.append(_generateEventFlow, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public String generateEventFlow(final Match match) {
    int target = (-1);
    int halftime = 0;
    StringBuilder _stringBuilder = new StringBuilder();
    StringBuilder ret = _stringBuilder;
    Event current = match.getFirstEvent();
    boolean _notEquals = (!Objects.equal(current, null));
    boolean _while = _notEquals;
    while (_while) {
      {
        int _time = current.getTime();
        boolean _greaterThan = (_time > target);
        if (_greaterThan) {
          int _plus = (halftime + 1);
          halftime = _plus;
          int _moveTarget = this.moveTarget(target);
          target = _moveTarget;
          String _generateHalfTimeHeader = this.generateHalfTimeHeader(halftime);
          ret.append(_generateHalfTimeHeader);
        }
        CharSequence _generateEvent = this.generateEvent(current);
        ret.append(_generateEvent);
        Event _next = current.getNext();
        current = _next;
      }
      boolean _notEquals_1 = (!Objects.equal(current, null));
      _while = _notEquals_1;
    }
    return ret.toString();
  }
  
  public int moveTarget(final int i) {
    int _minus = (-1);
    boolean _equals = (i == _minus);
    if (_equals) {
      return 1200;
    }
    boolean _equals_1 = (i == 1200);
    if (_equals_1) {
      return 2400;
    }
    boolean _equals_2 = (i == 2400);
    if (_equals_2) {
      return 2700;
    }
    return 3000;
  }
  
  public String generateHalfTimeHeader(final int i) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(i,1)) {
        _matched=true;
        _switchResult = "\\subsection{Els\u0151 f\u00E9lid\u0151}";
      }
    }
    if (!_matched) {
      if (Objects.equal(i,2)) {
        _matched=true;
        _switchResult = "\\subsection{M\u00E1sodik f\u00E9lid\u0151}";
      }
    }
    if (!_matched) {
      if (Objects.equal(i,3)) {
        _matched=true;
        _switchResult = "\\subsection{Hosszabb\u00EDt\u00E1s els\u0151 f\u00E9lideje}";
      }
    }
    if (!_matched) {
      if (Objects.equal(i,4)) {
        _matched=true;
        _switchResult = "\\subsection{Hosszabb\u00EDt\u00E1s m\u00E1sodik f\u00E9lideje}";
      }
    }
    if (!_matched) {
      _switchResult = "";
    }
    return _switchResult;
  }
  
  public CharSequence generateEvent(final Event event) {
    if ((event instanceof Goal)) {
      return this.generateGoal(((Goal) event));
    }
    if ((event instanceof Fault)) {
      return this.generateFault(((Fault) event));
    }
    if ((event instanceof Substitution)) {
      return this.generateSubstitution(((Substitution) event));
    }
    if ((event instanceof TimeOut)) {
      return this.generateTimeout(((TimeOut) event));
    }
    return "";
  }
  
  public CharSequence generateGoal(final Goal goal) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\\noindent\\textbf{");
    int _time = goal.getTime();
    String _timeToString = GeneratorHelper.timeToString(_time, true);
    _builder.append(_timeToString, "");
    _builder.append(":} ");
    Player _player = goal.getPlayer();
    String _name = _player.getName();
    _builder.append(_name, "");
    _builder.append(" (");
    Player _player_1 = goal.getPlayer();
    int _squadNumber = _player_1.getSquadNumber();
    _builder.append(_squadNumber, "");
    _builder.append(") ");
    String _xifexpression = null;
    Player _player_2 = goal.getPlayer();
    Team _team = _player_2.getTeam();
    Team _scorerTeam = goal.getScorerTeam();
    boolean _notEquals = (!Objects.equal(_team, _scorerTeam));
    if (_notEquals) {
      _xifexpression = "\u00F6ng\u00F3lt";
    } else {
      _xifexpression = "g\u00F3lt";
    }
    _builder.append(_xifexpression, "");
    _builder.append(" r\u00FAg, pontot szerez a(z) ");
    Team _scorerTeam_1 = goal.getScorerTeam();
    String _name_1 = _scorerTeam_1.getName();
    _builder.append(_name_1, "");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateFault(final Fault fault) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\\noindent\\textbf{");
    int _time = fault.getTime();
    String _timeToString = GeneratorHelper.timeToString(_time, true);
    _builder.append(_timeToString, "");
    _builder.append(":} ");
    Player _player = fault.getPlayer();
    String _name = _player.getName();
    _builder.append(_name, "");
    _builder.append(" (");
    Player _player_1 = fault.getPlayer();
    int _squadNumber = _player_1.getSquadNumber();
    _builder.append(_squadNumber, "");
    _builder.append(") szab\u00E1lytalankodik, b\u00FCntet\u00E9se ");
    String _switchResult = null;
    FaultType _type = fault.getType();
    final FaultType _switchValue = _type;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,FaultType.PENALTY)) {
        _matched=true;
        _switchResult = "szabadr\u00FAg\u00E1s a m\u00E1sik csapatnak";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,FaultType.YELLOW_CARD)) {
        _matched=true;
        _switchResult = "s\u00E1rga lap";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,FaultType.RED_CARD)) {
        _matched=true;
        _switchResult = "piros lap";
      }
    }
    if (!_matched) {
      _switchResult = "";
    }
    _builder.append(_switchResult, "");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateSubstitution(final Substitution substitution) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\\noindent\\textbf{");
    int _time = substitution.getTime();
    String _timeToString = GeneratorHelper.timeToString(_time, true);
    _builder.append(_timeToString, "");
    _builder.append(":} Csere a(z) ");
    Player _substitute = substitution.getSubstitute();
    Team _team = _substitute.getTeam();
    String _name = _team.getName();
    _builder.append(_name, "");
    _builder.append(" csapatn\u00E1l, ");
    Player _substitute_1 = substitution.getSubstitute();
    String _name_1 = _substitute_1.getName();
    _builder.append(_name_1, "");
    _builder.append(" (");
    Player _substitute_2 = substitution.getSubstitute();
    int _squadNumber = _substitute_2.getSquadNumber();
    _builder.append(_squadNumber, "");
    _builder.append(") j\u00E1t\u00E9kba \u00E1ll ");
    Player _instead = substitution.getInstead();
    String _name_2 = _instead.getName();
    _builder.append(_name_2, "");
    _builder.append(" (");
    Player _instead_1 = substitution.getInstead();
    int _squadNumber_1 = _instead_1.getSquadNumber();
    _builder.append(_squadNumber_1, "");
    _builder.append(") helyett.");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateTimeout(final TimeOut timeout) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\\noindent\\textbf{");
    int _time = timeout.getTime();
    String _timeToString = GeneratorHelper.timeToString(_time, true);
    _builder.append(_timeToString, "");
    _builder.append(":} A(z) ");
    Team _team = timeout.getTeam();
    String _name = _team.getName();
    _builder.append(_name, "");
    _builder.append(" csapat id\u0151t k\u00E9r.");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateResult(final Match match) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\\section{\u00D6sszefoglal\u00E1s}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\subsection{V\u00E9geredm\u00E9ny}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\noindent\\textbf{");
    Team _team1 = match.getTeam1();
    String _name = _team1.getName();
    _builder.append(_name, "");
    _builder.append(":} ");
    Team _team1_1 = match.getTeam1();
    int _calculateScore = GeneratorHelper.calculateScore(_team1_1, false);
    _builder.append(_calculateScore, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\\noindent\\textbf{");
    Team _team2 = match.getTeam2();
    String _name_1 = _team2.getName();
    _builder.append(_name_1, "");
    _builder.append(":} ");
    Team _team2_1 = match.getTeam2();
    int _calculateScore_1 = GeneratorHelper.calculateScore(_team2_1, false);
    _builder.append(_calculateScore_1, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\\subsection{F\u00E9lid\u0151ben}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\\noindent\\textbf{");
    Team _team1_2 = match.getTeam1();
    String _name_2 = _team1_2.getName();
    _builder.append(_name_2, "");
    _builder.append(":} ");
    Team _team1_3 = match.getTeam1();
    int _calculateScore_2 = GeneratorHelper.calculateScore(_team1_3, true);
    _builder.append(_calculateScore_2, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\\noindent\\textbf{");
    Team _team2_2 = match.getTeam2();
    String _name_3 = _team2_2.getName();
    _builder.append(_name_3, "");
    _builder.append(":} ");
    Team _team2_3 = match.getTeam2();
    int _calculateScore_3 = GeneratorHelper.calculateScore(_team2_3, true);
    _builder.append(_calculateScore_3, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public String notNull(final String string) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(string, null);
    if (_equals) {
      _xifexpression = "-";
    } else {
      _xifexpression = string;
    }
    return _xifexpression;
  }
  
  public String notNull(final Date date) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(date, null);
    if (_equals) {
      _xifexpression = "-";
    } else {
      String _localeString = date.toLocaleString();
      _xifexpression = _localeString;
    }
    return _xifexpression;
  }
}
