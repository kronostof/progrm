# Pour demain #
+compulser la doc sérieusement.<br>
+chaînage en série.<br>
++Rajouter les dates au cahier de bord et le compéter.<br>
++Ajouter l'interface graphique.<br>

<h1>Hitorique</h1>
=Mercredi 28 Janvier<br>
Utilisation du pluging : EclipseUML 2008 <br> <a href='http://www.omondo.com'> www.omondo.com </a><br>
Aussi dispo sur ce site.<br>
Du code qui a tendance a ressembler a un plat de pâtes.<br>
<br>
Il faut penser a modifier le fichier eclipse.ini<br>
<pre><code>-showsplash<br>
org.eclipse.platform<br>
--launcher.XXMaxPermSize<br>
256M<br>
-framework<br>
plugins\org.eclipse.osgi_3.4.2.R34x_v20080826-1230.jar<br>
-vmargs<br>
-Dosgi.requiredJavaVersion=1.5<br>
-Xms40m<br>
-Xmx256m<br>
</code></pre>

Avec les valeurs<br>
<br>
<pre><code>-Xms40m<br>
-Xmx512m<br>
-XX:PermSize=512m<br>
</code></pre>
<h1>mardi 27 Janvier</h1>
Interface Graphique OK<br>
<br>
<h1>lundi 26 Janvier</h1>
Reprise de l'interface graphique.<br>
<br>
<br>
<h1>Jeudi 15 Janvier</h1>
+Enchaîner une dizaine de module avec une traitement représentatif.<br>

Grosse frayeur avec cinq module le processeur dérouille.En cherchant l'origine du probleme on en optimise le code.<br>
la partie<br>
<pre><code><br>
abstract class Flux&lt;E extends Information&gt; extends Thread`*`(<br>
	...<br>
	abstract public void set(E fe);<br>
	...<br>
</code></pre>
Est un non sens.on ne recree pas un obj pour l'inserer ds le flux destionnataire.<br>
Ce sera<br>
<pre><code><br>
abstract class Flux&lt;E extends Information&gt; extends Thread`*`(<br>
	...<br>
        abstract public void set(_liste dargument qui va bien pour modifier le champs data du flux_);<br>
	...<br>
</code></pre>
Si pour cinq module on sens la différence...<br>
<br>
Comme en c# c'est l'affichage qui  coince, sans afficher a chaque nouvel element ds le fulx ça passe En même temps 5*toString a 50hz fallait s'y attendre,non?<br>
oki: 30 module en parallèles les module déterminent si on regarde ou non une région ( chaque forme aura son module).<br>
<br>
On introduit la notion de <i>upToDate</i> pour le chainnage en série de demain ( ou comment faire la différance entre une donnée et une donnée périmer.Il faudra faire passer ça dans la partie recevant le flux pour que plusieurs mod travaillant sur le même flux puissent le percevoir différement.<br>
<br>
<h3>Grosse mise a plat</h3>

On réfléchit, on respire, on ce détend.<br>
Notion de UpToDate a cristalliser ds les commentaire et la doc.<br>
La classe lecteur se spécialise dans la récuperation des coordonnée par souris(socket plus tard), la classe Fluxposition retourne a qlq ch de plus rationnel ( plus de lireMouse 8O, Flux n'est plus <i>runnable</i>)<br>
Élagage de code en masse<br>

<h1>Mercerdi 14 Janvier</h1>

Code.Google.com<br>
svn<br>
<del>sourceforge</del>

<h1>Mardi 13 Janvier</h1>

<h3>Mise a plat</h3>
On repare sur de bonne base. Un module sera une classe et non trois 8O<br>
En plus ça marche ! ! !<br>
<br>
<h1>Lundi 12 Janvier</h1>
<h3>Esper plusieurs modules</h3>
premier jet de code, ça marche mais c'est vachement flou tout ça !<br>
On a :<br>
-une classe pour un évenement<br>
-une classe qui écoute<br>
-une classe qui envoie tout les événement <br>
<h1>Vendredi 9 Janvier</h1>
<h3>J'Esper que ça marche</h3>
Validation de l'utilisation d'Esper.<br>
<h3>Esper utilisation</h3>

<h3>Esper</h3>
Passage a Esper, parce que jamais tu désEspere.<br>
La phrase <br><i>Esper and NEsper enable rapid development of applications that process large volumes of incoming messages or events. Esper and NEsper filter and analyze events in various ways, and respond to conditions of interest in real-time</i><br>
A Quelque chose de rassurant,non?<br>
<br>
L'utilisation du langage java n'est finalement pas un frein pour la conception d'un programme a haute charge par unitée de temps =>c'est parti pour du java?<br>
<br>
<a href='http://esper.codehaus.org'>site officiel</a>

<h3>NEsper</h3>
Le développement du projet début en c#. A la recherche de code, d'info et de ressource sur les CEP et ESP, On s'orriente vers NEsper... jusqu'a se rendre compte que<br>
<li><a href='http://esper.codehaus.org/tutorials/faq_nesper/faq.html#multithread-safety'>Le support du multithread était assez récent pour ne pas en parler possitivement</a>
<li><a href='http://esper.codehaus.org/tutorials/faq_nesper/faq.html#tested_on_OS'>l'espace d'expression était assez réduit</a>

<h1>Avant 7 Janvier</h1>

<h3>open-esb</h3>
Un site désesperément lent peu nuir!<br>
Apparement se qu'il nous faut ( si on avait beaucoup, beaucoup, de temps) Mais en java.<br>
<a href='https://open-esb.dev.java.net/AboutOpenEsb.html'> si vous avez du temps </a>

<h3>tripatouillage</h3>

<li> On va pouvoir commencer a travailler.<br>
<li> joujou avec l'interface graphique on affiche un truc moche :p<br>
<li> joujou avec bout de code N°2 modification interface on commande la machine a distance.<br>
<li> joujou avec bout de code fourni par le fournisseur de l occulo qui ne fait pas grand chose,en c++ et c# On part sur du c#.<br>
<li> joujou avec l'occulomètre (sans le casser) configuration,test,comment ça marche ...