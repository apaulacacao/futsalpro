package hu.bme.mit.inf.mvsd.futsal.reportgeneration

import hu.bme.mit.inf.mvsd.domain.generated.futsal.Match
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Player
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Crew
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Goal
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Fault
import hu.bme.mit.inf.mvsd.domain.generated.futsal.FaultType
import hu.bme.mit.inf.mvsd.domain.generated.futsal.Substitution

class HtmlGenerator {
	
	def generate(Match match, String path) {
		GeneratorHelper::writeHtmlFile(path, generateHtml(match).toString);
	}
	
	def generateHtml(Match match) '''
<!DOCTYPE html>
<html>
«generateHtmlHeader(match)»
«generateHtmlBody(match)»
</html>
	'''
	
	def generateHtmlHeader(Match match)	'''
<head>
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="Content-Type" content="text/html; charset=windows-1250" />
<meta http-equiv="Content-Language" content="hu" />
<meta name="title" content="Magyar Labdarúgó Szövetség Adatbank" />
<meta name="description" content="Magyar Labdarúgó Szövetség Adatbank" />
<meta name="keywords" content="mlsz foci labdarúgás football adatbank" />
<meta name="language" content="magyar" />
<!--meta name="copyright" content="Copyright &copy; 2009 SZÁMÍTHAT KFT" /-->
<meta name="robots" content="index, follow, all" />
<meta name="distribution" content="Global" />
<meta name="revisit-after" content="1 Week" />
<meta name="rating" content="General" />
<meta name="doc-type" content="Web Page" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="verify-v1" content="NbcFoFDQeCFhmcD57l4QmYh9w3z0nCGSetVfJgIUDnI=" />
<title>Magyar Labdarúgó Szövetség adatbankja - MVSD</title>
<link rel="stylesheet" href="http://adatbank.mlsz.hu/_include/include.css" type="text/css">
<script type="text/javascript" src="http://adatbank.mlsz.hu/_include/util.js"></script>
<script type="text/VBScript" src="http://adatbank.mlsz.hu/_include/utilvb.js"></script>
</head>
'''

	def generateHtmlBody(Match match)'''
<body topmargin="0" leftmargin="0" link="#000080" vlink="#000080" alink="#000080" OnKeyDown="ProcessKeyDown();">
<DIV id=overDiv style="Z-INDEX: 1000; VISIBILITY: hidden; POSITION: absolute"></DIV>
<SCRIPT language="VBScript">
function ProcessKeyDown()
   Dim WinEvent
   Set WinEvent = window.event
   if WinEvent.keycode = 13 Then
      WinEvent.keycode = 9
   End if
End function
</SCRIPT>
<body topmargin="0" leftmargin="0" link="#000080" vlink="#000080" alink="#000080" OnKeyDown="ProcessKeyDown();" style="background: url('/images/hatter/bg_homok.jpg') repeat-x;">
<center>
«generateTableHeader(match)»
«generateStarters(match)»
«generateSubstitutes(match)»
«generateBench(match)»
«generateScorers(match)»
«generateFaults(match)»
«generateSubstitutions(match)»
         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr><td class="URES_BARNA" width="740" height="1"></td></tr>
         </table>             
         
      </td>   
      <td width="10"></td>
   </tr>
</table>
</body>
		'''
		
	def generateTableHeader(Match match)'''
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" width="740" height="600">
   <tr>
      <td width="10"></td>
      <td valign="top">
         
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr>
      <td class="URES_BARNA" width="10"></td>
      <td class="FEHER_BARNA_CL13" width="360" height="30"><b>«match.chanmpionship»</b></td>
      <td class="FEHER_BARNA_CR13" width="340"><b>Magyar Labdarúgó Szövetség</b></td>
      <td class="URES_BARNA" width="10"></td>
   </tr>
</table> 
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr>
      <td class="URES_HATTER_1" width="10"></td>
      <td class="BARNA_HATTER_1_CL13" width="220" height="25"><b>«match.date.toLocaleString()»</b></td>
      <td class="BARNA_HATTER_1_CR13" width="500"><b>«match.location.address», «match.location.name»</b></td>
      <td class="URES_HATTER_1" width="10"></td>
   </tr>
</table> 
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr><td class="URES_BARNA" width="720"></td></tr>
</table> 
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr>            
      <td class="FEKETE_TRANSPARENT_CC14" width="314" height="36">
         <b>
         «match.team1.name»
         </b>
      </td>            
      <td>
         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse" background="http://adatbank.mlsz.hu/images/hatter/eredmeny_72x36.jpg">
            <tr>
               <td>
                  <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
                  
                     <tr><td class="FEHER_TRANSPARENT_CC18" width="72" height="21"><b>«GeneratorHelper::calculateScore(match.team1, false)» - «GeneratorHelper::calculateScore(match.team2, false)»</b></td></tr>
                     <tr><td class="FEHER_TRANSPARENT_CC11" width="72" height="14"><b>«GeneratorHelper::calculateScore(match.team1, true)» - «GeneratorHelper::calculateScore(match.team2, true)»</b></td></tr>
 

                  </table>
               </td>
            </tr>
         </table>
      </td>
      <td class="FEKETE_TRANSPARENT_CC14" width="314">
         <b>
         «match.team2.name»
         </b>
      </td>
   </tr>            
</table>

<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr><td class="URES_BARNA" width="720" height="1"></td></tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr>         
      <td class="URES_HATTER_1">
        <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr>
               <td width="10"></td>         
               <td class="FEKETE_TRANSPARENT_CL10" width="65" height="20">játékvezető:</td>
               <td width="165">
                  
                  <div class="MOff" style="cursor: pointer;" onMouseOut="this.className='MOff';" onmouseover="this.className='MOn_1';" OnClick="jatekvezeto_nez_p01_jegyzokonyv_nez_1('«if (match.referee1 == null) 0 else match.referee1.identifier»');">         
                  <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
                     <tr><td class="FEKETE_TRANSPARENT_CL10" width="165"><b>«if (match.referee1 == null || match.referee1.name == null) "" else match.referee1.name.toUpperCase» </b></td></tr>
                  </table>
                  </div>
                  
               </td> 
               <td class="URES_SZURKE" width="1"></td>
               <td width="4"></td>
               <td class="FEKETE_TRANSPARENT_CL10" width="65">asszisztens:</td>
               <td width="165">
                  
                  <div class="MOff" style="cursor: pointer;" onMouseOut="this.className='MOff';" onmouseover="this.className='MOn_1';" OnClick="jatekvezeto_nez_p01_jegyzokonyv_nez_1('«if (match.referee2 == null) 0 else match.referee2.identifier»');">         
                  <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
                     <tr><td class="FEKETE_TRANSPARENT_CL10" width="165"><b>«if (match.referee2 == null || match.referee2.name == null) "" else match.referee2.name.toUpperCase» </b></td></tr>
                  </table>
                  </div>
                  
               </td>
               <td class="URES_SZURKE" width="1"></td>
               <td width="4"></td>
               <td class="FEKETE_TRANSPARENT_CL10" width="65">ellenőr:</td>
               <td width="165">
                  
                  <div class="MOff" style="cursor: pointer;" onMouseOut="this.className='MOff';" onmouseover="this.className='MOn_1'; OnClick="jatekvezeto_nez_p01_jegyzokonyv_nez_1('«if (match.supervisor == null) 0 else match.supervisor.identifier»');">         
                  <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
                     <tr><td class="FEKETE_TRANSPARENT_CL10" width="165"><b>«if (match.supervisor == null || match.supervisor.name == null) "" else match.supervisor.name.toUpperCase» </b></td></tr>
                  </table>
                  </div>
                  
               </td>
               <td width="10"></td> 
            </tr>
            <tr>         
               <td width="10"></td> 
               <td class="FEKETE_TRANSPARENT_CL10" width="65" height="20">tartjv.:</td>
               <td width="165">
                  
                  <div class="MOff" style="cursor: pointer;" onMouseOut="this.className='MOff';" onmouseover="this.className='MOn_1';">         
                  <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
                     <tr><td class="FEKETE_TRANSPARENT_CL10" width="165"></td></tr>
                  </table>
                  </div>
                  
               </td> 
               <td class="URES_SZURKE" width="1"></td>
               <td width="4"></td>
               <td width="65"></td>
               <td width="165">
                  
                  <div class="MOff" style="cursor: pointer;" onMouseOut="this.className='MOff';" onmouseover="this.className='MOn_1';" OnClick="jatekvezeto_nez_p01_jegyzokonyv_nez_1('«if (match.referee3 == null) 0 else match.referee3.identifier»');">         
                  <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
                     <tr><td class="FEKETE_TRANSPARENT_CL10" width="165"><b>«if (match.referee3 == null || match.referee3.name == null) "" else match.referee3.name.toUpperCase» </b></td></tr>
                  </table>
                  </div>
                  
               </td>
               <td class="URES_SZURKE" width="1"></td>
               <td width="4"></td>
               <td class="FEKETE_TRANSPARENT_CL10" width="65">szöv.ell.:</td>
               <td width="165">
                  
               </td>
               <td width="10"></td> 
            </tr>
         </table>     
      </td>
   </tr>
</table>                      
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr>         
      <td class="URES_BARNA">
         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr>
               <td width="10"></td>
               <td class="FEHER_TRANSPARENT_CR11" width="50" height="15">forduló</td>
               <td width="4"></td>        
               <td class="URES_SZURKE" width="1"></td>
               <td width="4"></td>    
               <td class="FEHER_TRANSPARENT_CL11" width="120">szakág</td>                 
               <td class="URES_SZURKE" width="1"></td>  
               <td width="4"></td>    
               <td class="FEHER_TRANSPARENT_CL11" width="157">korosztály</td>                 
               <td class="URES_SZURKE" width="1"></td>  
               <td width="4"></td>    
               <td class="FEHER_TRANSPARENT_CL11" width="95">típus</td> 
               <td class="URES_SZURKE" width="1"></td>  
               <td width="4"></td>    
               <td class="FEHER_TRANSPARENT_CL11" width="95">évad</td> 
               <td class="URES_SZURKE" width="1"></td>  
               <td class="FEHER_TRANSPARENT_CR11" width="178">mérkőzés kódja</td>
               <td width="10"></td>
            </tr>
            <tr>
               <td width="10"></td>
               <td class="FEHER_TRANSPARENT_CR14" width="50" height="20"><b>«if (match.round == null) "-" else match.round + "."»</b></td>
               <td width="4"></td>        
               <td class="URES_SZURKE" width="1"></td>
               <td width="4"></td>    
               <td class="FEHER_TRANSPARENT_CL12" width="120"><b>«if (match.section == null) "-" else match.section»</b></td>                 
               <td class="URES_SZURKE" width="1"></td>  
               <td width="4"></td>    
               <td class="FEHER_TRANSPARENT_CL12" width="157"><b>«if (match.ageGroup == null) "-" else match.ageGroup»</b></td>                 
               <td class="URES_SZURKE" width="1"></td>  
               <td width="4"></td>    
               <td class="FEHER_TRANSPARENT_CL12" width="95"><b>«if (match.category == null) "-" else match.category»</b></td> 
               <td class="URES_SZURKE" width="1"></td>  
               <td width="4"></td>    
               <td class="FEHER_TRANSPARENT_CL12" width="95"><b>«if (match.season == null) "-" else match.season»</b></td> 
               <td class="URES_SZURKE" width="1"></td>  
               <td class="FEHER_TRANSPARENT_CR12" width="178"><b>«if (match.code == null) "-" else match.code»</b></td>
               <td width="10"></td>
            </tr>
         </table>  
      </td>
   </tr>
</table>
'''

	def generateStarters(Match match)
'''
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr>
      <td class="FEKETE_TRANSPARENT_CR09" width="20" height="15">mez</td>
      <td width="4"></td>
      <td class="URES_SZURKE" width="1"></td>
      <td width="5"></td>
      <td class="FEKETE_TRANSPARENT_CL10" width="100">név</td>
      <td class="BARNA_TRANSPARENT_CL11" width="169"><b>Kezdő</b></td>
      <td class="URES_SZURKE" width="1"></td>
      <td class="FEKETE_TRANSPARENT_CR10" width="50">igazolás</td>
      <td width="9"></td>
      <td class="URES_BARNA" width="1"></td>
      <td width="10"></td>
      <td class="FEKETE_TRANSPARENT_CR09" width="20">mez</td>
      <td width="4"></td>
      <td class="URES_SZURKE" width="1"></td>
      <td width="5"></td>
      <td class="FEKETE_TRANSPARENT_CL10" width="100">név</td>
      <td class="BARNA_TRANSPARENT_CL11" width="169"><b>Kezdő</b></td>
      <td class="URES_SZURKE" width="1"></td>
      <td class="FEKETE_TRANSPARENT_CR10" width="50">igazolás</td>
   </tr>         
</table>
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr>
      <td width="350" valign="top">
      
         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr><td class="URES_SZURKE" width="350" height="1"></td></tr>
         </table>                 

         «generatePlayer(match.team1.goalKeeper)»
         «FOR player : match.team1.fieldPlayers»
         «generatePlayer(player)»
         «ENDFOR»
         
      </td>
      <td width="9"></td>
      <td class="URES_BARNA" width="1"></td>
      <td width="10"></td>
      <td width="350" valign="top">
      
         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr><td class="URES_SZURKE" width="350" height="1"></td></tr>
         </table>

         «generatePlayer(match.team2.goalKeeper)»
         «FOR player : match.team2.fieldPlayers»
         «generatePlayer(player)»
         «ENDFOR»
               
      </td>
   </tr>            
</table>
'''

	def generatePlayer(Player player) '''
         <div class="MOff" style="cursor: pointer; width: 350;" onMouseOut="this.className='MOff';" onmouseover="this.className='MOn_1';" OnClick="jatekos_nez_p01_jegyzokonyv_nez_2('148232');">          
         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr>                        
               <td class="FEKETE_TRANSPARENT_CR11" width="20" height="15">«player.squadNumber»</td>
               <td width="4"></td>
               <td class="URES_SZURKE" width="1"></td>
               <td width="5"></td>
               <td class="FEKETE_TRANSPARENT_CL11" width="269">«player.name.toUpperCase»</td>
               <td class="URES_SZURKE" width="1"></td>
               <td class="FEKETE_TRANSPARENT_CR11" width="50">«player.licenceNumber»</td>
            </tr>
         </table>
         </div>
         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr><td class="URES_SZURKE" width="350" height="1"></td></tr>
         </table>
'''

	def generateSubstitutes(Match match)'''
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr><td class="URES_BARNA" width="720" height="1"></td></tr>
</table>    
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr>
      <td class="FEKETE_TRANSPARENT_CR09" width="20" height="15">mez</td>
      <td width="4"></td>
      <td class="URES_SZURKE" width="1"></td>
      <td width="5"></td>
      <td class="FEKETE_TRANSPARENT_CL10" width="100">név</td>
      <td class="BARNA_TRANSPARENT_CL11" width="169"><b>Csere</b></td>
      <td class="URES_SZURKE" width="1"></td>
      <td class="FEKETE_TRANSPARENT_CR10" width="50">igazolás</td>
      <td width="9"></td>
      <td class="URES_BARNA" width="1"></td>
      <td width="10"></td>
      <td class="FEKETE_TRANSPARENT_CR09" width="20">mez</td>
      <td width="4"></td>
      <td class="URES_SZURKE" width="1"></td>
      <td width="5"></td>
      <td class="FEKETE_TRANSPARENT_CL10" width="100">név</td>
      <td class="BARNA_TRANSPARENT_CL11" width="169"><b>Csere</b></td>
      <td class="URES_SZURKE" width="1"></td>
      <td class="FEKETE_TRANSPARENT_CR10" width="50">igazolás</td>
   </tr>         
</table>  
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr>
      <td width="350" valign="top">
      
         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr><td class="URES_SZURKE" width="350" height="1"></td></tr>
         </table>                  

         «FOR substitute : match.team1.subtitutePlayers»
         «generatePlayer(substitute)»
         «ENDFOR»
   
      </td>
      <td width="9"></td>
      <td class="URES_BARNA" width="1"></td>
      <td width="10"></td>
      <td width="350" valign="top">

         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr><td class="URES_SZURKE" width="350" height="1"></td></tr>
         </table>
         
         «FOR substitute : match.team2.subtitutePlayers»
         «generatePlayer(substitute)»
         «ENDFOR»
   
      </td>
   </tr>            
</table>
'''
	
	def generateBench(Match match)'''
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr><td class="URES_BARNA" width="720" height="1"></td></tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr>
      <td class="FEKETE_TRANSPARENT_CL10" width="100">név</td>
      <td class="BARNA_TRANSPARENT_CL11" width="199"><b>Kispad</b></td>
      <td class="URES_SZURKE" width="1"></td>
      <td class="FEKETE_TRANSPARENT_CR10" width="50">igazolás</td>
      <td width="9"></td>
      <td class="URES_BARNA" width="1"></td>
      <td width="10"></td>
      <td class="FEKETE_TRANSPARENT_CL10" width="100">név</td>
      <td class="BARNA_TRANSPARENT_CL11" width="199"><b>Kispad</b></td>
      <td class="URES_SZURKE" width="1"></td>
      <td class="FEKETE_TRANSPARENT_CR10" width="50">igazolás</td>
   </tr>         
</table>
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr>
      <td width="350" valign="top">                  

         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr><td class="URES_SZURKE" width="350" height="1"></td></tr>
         </table>

         «FOR crew : match.team1.bench»
         «generateCrew(crew)»
         «ENDFOR»
   
      </td>
      <td width="9"></td>
      <td class="URES_BARNA" width="1"></td>
      <td width="10"></td>
      <td width="350" valign="top">

         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr><td class="URES_SZURKE" width="350" height="1"></td></tr>
         </table>

         «FOR crew : match.team2.bench»
         «generateCrew(crew)»
         «ENDFOR»
               
      </td>
   </tr>            
</table>
'''

	def generateCrew(Crew crew)'''
         <div class="MOff" style="cursor: pointer; width: 350;" onMouseOut="this.className='MOff';" onmouseover="this.className='MOn_1';">          
         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr>                        
               <td class="FEKETE_TRANSPARENT_CL11" width="215" height="15">«crew.name.toUpperCase»</td>
               <td class="FEKETE_TRANSPARENT_CL09" width="84">«GeneratorHelper::roleToString(crew.role)»</td>
               <td class="URES_SZURKE" width="1"></td>
               <td class="FEKETE_TRANSPARENT_CR11" width="50">«crew.licenceNumber»</td>
            </tr>
         </table>
         </div>
         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr><td class="URES_SZURKE" width="350" height="1"></td></tr>
         </table>
'''

	def generateScorers(Match match)'''
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr><td class="URES_BARNA" width="720" height="1"></td></tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr>
      <td class="FEKETE_TRANSPARENT_CR10" width="20" height="15">idő</td>
      <td width="4"></td>
      <td class="URES_SZURKE" width="1"></td>
      <td width="5"></td>
      <td class="FEKETE_TRANSPARENT_CL10" width="100">név</td>
      <td class="BARNA_TRANSPARENT_CL11" width="165"><b>Góllövő</b></td>
      <td width="4"></td>
      <td class="URES_SZURKE" width="1"></td>
      <td class="FEKETE_TRANSPARENT_CR10" width="50">igazolás</td>
      <td width="9"></td>
      <td class="URES_BARNA" width="1"></td>
      <td width="10"></td>
      <td class="FEKETE_TRANSPARENT_CR10" width="20">idő</td>
      <td width="4"></td>
      <td class="URES_SZURKE" width="1"></td>
      <td width="5"></td>
      <td class="FEKETE_TRANSPARENT_CL10" width="100">név</td>
      <td class="BARNA_TRANSPARENT_CL11" width="165"><b>Góllövő</b></td>
      <td width="4"></td>
      <td class="URES_SZURKE" width="1"></td>
      <td class="FEKETE_TRANSPARENT_CR10" width="50">igazolás</td>
   </tr>         
</table>   
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr>
      <td width="350" valign="top">                  

         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr><td class="URES_SZURKE" width="350" height="1"></td></tr>
         </table>

         «FOR goal : GeneratorHelper::goalsOf(match.team1)»
         «generateScorer(goal)»
         «ENDFOR»
            
      </td>
      <td width="9"></td>
      <td class="URES_BARNA" width="1"></td>
      <td width="10"></td>
      <td width="350" valign="top">
         
         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr><td class="URES_SZURKE" width="350" height="1"></td></tr>
         </table>

         «FOR goal : GeneratorHelper::goalsOf(match.team2)»
         «generateScorer(goal)»
         «ENDFOR»
            
      </td>
   </tr>            
</table>
'''

	def generateScorer(Goal goal)'''
         <div class="MOff" style="cursor: pointer; width: 350;" onMouseOut="this.className='MOff';" onmouseover="this.className='MOn_1';" OnClick="jatekos_nez_p01_jegyzokonyv_nez_2('«goal.player.licenceNumber»');">          
         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr>                        
               <td class="ASCR10" width="20" height="15">«(goal.time-1)/60»'</td>
               <td width="4"></td>
               <td class="URES_SZURKE" width="1"></td>
               <td width="5"></td>
               <td class="FEKETE_TRANSPARENT_CL11" width="265">
                  «goal.player.name.toUpperCase» 
                  «if (goal.scorerTeam != goal.player.team) "(öngól)"»
               </td>     
               <td class="FEKETE_TRANSPARENT_CL10" width="4"></td>
               <td class="URES_SZURKE" width="1"></td>
               <td class="FEKETE_TRANSPARENT_CR11" width="50">«goal.player.licenceNumber»</td> 
            </tr>
         </table>
         </div>
         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr><td class="URES_SZURKE" width="350" height="1"></td></tr>
         </table>
'''

	def generateFaults(Match match)'''
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr><td class="URES_BARNA" width="720" height="1"></td></tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr>
      <td class="FEKETE_TRANSPARENT_CR10" width="20" height="15">idő</td>
      <td width="4"></td>
      <td class="URES_SZURKE" width="1"></td>
      <td width="5"></td>
      <td class="FEKETE_TRANSPARENT_CL10" width="100">név</td>
      <td class="BARNA_TRANSPARENT_CL11" width="115"><b>Sárga-Piros lap</b></td>
      <td class="URES_SZURKE" width="1"></td>
      <td width="4"></td>
      <td class="FEKETE_TRANSPARENT_CL10" width="49">lap</td>
      <td class="URES_SZURKE" width="1"></td>
      <td class="FEKETE_TRANSPARENT_CR10" width="50">igazolás</td>
      <td width="9"></td>
      <td class="URES_BARNA" width="1"></td>
      <td width="10"></td>
      <td class="FEKETE_TRANSPARENT_CR10" width="20">idő</td>
      <td width="4"></td>
      <td class="URES_SZURKE" width="1"></td>
      <td width="5"></td>
      <td class="FEKETE_TRANSPARENT_CL10" width="100">név</td>
      <td class="BARNA_TRANSPARENT_CL11" width="115"><b>Sárga-Piros lap</b></td>
      <td class="URES_SZURKE" width="1"></td>
      <td width="4"></td>
      <td class="FEKETE_TRANSPARENT_CL10" width="49">lap</td>
      <td class="URES_SZURKE" width="1"></td>
      <td class="FEKETE_TRANSPARENT_CR11" width="50">igazolás</td>
   </tr>         
</table>
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr>
      <td width="350" valign="top">                  

         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr><td class="URES_SZURKE" width="350" height="1"></td></tr>
         </table>

         «FOR fault : GeneratorHelper::faultsOf(match.team1)»
         «generateFault(fault)»
         «ENDFOR»

      </td>
      <td width="9"></td>
      <td class="URES_BARNA" width="1"></td>
      <td width="10"></td>
      <td width="350" valign="top">
            
         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr><td class="URES_SZURKE" width="350" height="1"></td></tr>
         </table>

         «FOR fault : GeneratorHelper::faultsOf(match.team2)»
         «generateFault(fault)»
         «ENDFOR»
            
      </td>
   </tr>            
</table>
	'''	
	
	def generateFault(Fault fault)'''
         <div class="MOff" style="cursor: pointer; width: 350;" onMouseOut="this.className='MOff';" onmouseover="this.className='MOn_1';" OnClick="jatekos_nez_p01_jegyzokonyv_nez_2('«fault.player.licenceNumber»');">          
         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr>
               <td class="FEKETE_TRANSPARENT_CR10" width="20" height="15">«(fault.time-1)/60»'</td>
               <td width="4"></td>
               <td class="URES_SZURKE" width="1"></td>
               <td width="5"></td>
               <td class="FEKETE_TRANSPARENT_CL11" width="215">«fault.player.name.toUpperCase»</td>
               <td class="URES_SZURKE" width="1"></td>
               <td width="4"></td>
               <td class=«faultToClass(fault.type)» width="49">«GeneratorHelper::faultToString(fault.type)»</td>                    
               <td class="URES_SZURKE" width="1"></td>
               <td class="FEKETE_TRANSPARENT_CR11" width="50">«fault.player.licenceNumber»</td>
            </tr>
         </table>
         </div>
         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr><td class="URES_SZURKE" width="350" height="1"></td></tr>
         </table>
	'''
	
	def faultToClass(FaultType type)
	{
		if (type == FaultType::YELLOW_CARD)
			return "HACC09";
		if (type == FaultType::RED_CARD)
			return "GACC09";
		return "\"FEKETE_TRANSPARENT_CL09\"";
	}
	
	def generateSubstitutions(Match match)'''
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr><td class="URES_BARNA" width="720" height="1"></td></tr>
</table>    
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr>
      <td class="FEKETE_TRANSPARENT_CR09" width="20" height="15">mez</td>
      <td width="4"></td>
      <td class="URES_SZURKE" width="1"></td>
      <td width="5"></td>
      <td class="FEKETE_TRANSPARENT_CL10" width="100">név</td>
      <td class="BARNA_TRANSPARENT_CL11" width="169"><b>Csere</b></td>
      <td class="URES_SZURKE" width="1"></td>
      <td class="FEKETE_TRANSPARENT_CR10" width="50">igazolás</td>
      <td width="9"></td>
      <td class="URES_BARNA" width="1"></td>
      <td width="10"></td>
      <td class="FEKETE_TRANSPARENT_CR09" width="20">mez</td>
      <td width="4"></td>
      <td class="URES_SZURKE" width="1"></td>
      <td width="5"></td>
      <td class="FEKETE_TRANSPARENT_CL10" width="100">név <i>(idő)</i></td>
      <td class="BARNA_TRANSPARENT_CL11" width="169"><b>Csere</b></td>
      <td class="URES_SZURKE" width="1"></td>
      <td class="FEKETE_TRANSPARENT_CR10" width="50">igazolás</td>
   </tr>         
</table>  
<table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
   <tr>
      <td width="350" valign="top">
      
         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr><td class="URES_SZURKE" width="350" height="1"></td></tr>
         </table>                  

         «FOR substitution : GeneratorHelper::substitutionsOf(match.team1)»
         «generateSubstitution(substitution)»
         «ENDFOR»
   
      </td>
      <td width="9"></td>
      <td class="URES_BARNA" width="1"></td>
      <td width="10"></td>
      <td width="350" valign="top">

         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr><td class="URES_SZURKE" width="350" height="1"></td></tr>
         </table>
         
         «FOR substitution : GeneratorHelper::substitutionsOf(match.team2)»
         «generateSubstitution(substitution)»
         «ENDFOR»
   
      </td>
   </tr>            
</table>
'''
	
	def generateSubstitution(Substitution substitution)'''
         <div class="MOff" style="cursor: pointer; width: 350;" onMouseOut="this.className='MOff';" onmouseover="this.className='MOn_1';" OnClick="jatekos_nez_p01_jegyzokonyv_nez_2('«substitution.substitute.licenceNumber»');">          
         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr>
               <td class="FEKETE_TRANSPARENT_CR11" width="20" height="15">«substitution.substitute.squadNumber»</td>
               <td width="4"></td>
               <td class="URES_SZURKE" width="1"></td>
               <td width="5"></td>
               <td class="FEKETE_TRANSPARENT_CL11" width="269">«substitution.substitute.name.toUpperCase» </td>
               <td class="URES_SZURKE" width="1"></td>
               <td class="FEKETE_TRANSPARENT_CR11" width="50">«substitution.substitute.licenceNumber»</td>
            </tr>
         </table>
         </div>
         
         <div class="MOff" style="cursor: pointer; width: 350;" onMouseOut="this.className='MOff';" onmouseover="this.className='MOn_1';" OnClick="jatekos_nez_p01_jegyzokonyv_nez_2('«substitution.instead.licenceNumber»');">                   
         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr>
               <td class="FEKETE_TRANSPARENT_CR11" width="20" height="15"></td>
               <td width="4"></td>
               <td class="URES_SZURKE" width="1"></td>
               <td width="5"></td>
               <td class="FEKETE_TRANSPARENT_CL11" width="50"><i>«(substitution.time-1)/60»'</i></td>
               <td class="FEKETE_TRANSPARENT_CL10" width="219"><i>«substitution.instead.name.toUpperCase» helyett</i></td>
               <td class="URES_SZURKE" width="1"></td>
               <td class="FEKETE_TRANSPARENT_CR11" width="50"><i>«substitution.instead.licenceNumber»</i></td>
            </tr>
         </table>
         </div>
         
         <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
            <tr><td class="URES_SZURKE" width="350" height="1"></td></tr>
         </table> 
	'''
}