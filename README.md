<h1><span style="text-decoration: underline;"><strong>Packman Game</strong></span></h1>
<p>&copy;&nbsp;Wrriten by Ariel Bar and Moshe Elhadad.</p>
<p>In the project we started developing an infrastructure in order to represent a geographic information in a graphic tools ,in particular we created a pacman game .</p>
<p>&nbsp;In the project there are several packages:</p>
<h2>Geom:</h2>
<p>a package of geometric information including points , paths ,lines ,circles , squares.</p>
<h2>Coords:</h2>
<p>a basic coordinate system converter, using the following class Mycoords: including the following operation:</p>
<ol>
<li>The 3D vector between two lat,lon, alt points</li>
<li>Adding a 3D vector in meters to a global point.</li>
<li>convert a 3D vector from meters to polar coordinate</li>
</ol>
<h2>Algorithm:</h2>
<p><strong>*solutionForPacman:</strong></p>
<p>this class calculate the path between one pacman to each existing fruit ,searching the closest fruit with the minimum time &nbsp;,creating a new object which holds the information.</p>
<h3><strong>* ShortestPathAlgo:</strong></h3>
<p>The class ShortestPathAlgo represents the algorithm which calculating the paths of eating for all the pacmans in the game.</p>
<p>At first the algorithm&nbsp; calculating for each pacman its closest fruit by using "solutionForPacman" class , saving the result in a new array.</p>
<p>&nbsp;now the algorithm takes the pacman with the least&nbsp; time to its specific fruit from the new array,</p>
<p>&nbsp;the pacman will move forward and removed from the collection , the fruit is no longer can be eaten ,now do the same as long there are pacman in the new array</p>
<p>Afterwards, building in the same way a new collection without the fruits which have been eaten .The algorithm keeps running as long as there are fruit which can be eaten.</p>
<p>In the end of the process, each packman holds its own path, meaning which fruits the pacman had eaten .</p>
<h2>Type:</h2>
<p><strong>*Fruits</strong>-the class represent a single fruit which the pacman can eat , &nbsp;each fruit holds its own data such as:id ,weight,coordinates.</p>
<p><strong>*Packman</strong>-the class represents a single packman which can eat fruits.each pacman holds its own information such as: id,radiues of eat , speed , coordinates.</p>
<p><strong>*Game</strong>-the game represents a complete game including a collection of packmans and fruits.</p>
<h2>Maps:</h2>
<p><strong>*Convert</strong>- converting from pixels to coordinates and the other way around</p>
<p><strong>*Way</strong>- creating points between packman/fruit to fruit ,by using the time elements from the constructor .</p>
<p>this points will represents the movement of the specific packman .</p>
<p>&nbsp;</p>
<h2>GUI</h2>
<p><strong>*imageBackground</strong>- the calss responsible for the image background and for the game,</p>
<p>Reading csv file as a new game ,run the game .</p>
<p><strong>*gameboard</strong>-the class responsible for the main frame ,creating the menu , using the ImageBackground for drawing the elements,the map.</p>
<h2>FileFormat:</h2>
<p>&nbsp;<strong>*csv Reader</strong>- reading the csv file and saving the information.</p>
<p>&nbsp;<strong>*csv Data</strong>- holds the information accepting from the csv Reader</p>
<p><strong>*path2kml</strong>-the class creating a new kml page in order to open the game in gool earth</p>
<p><strong>*exportToCsv</strong>-the class creating a csv file with information of all the elements of game .</p>
<p>&nbsp;</p>
<h2>How to play?</h2>
<p>There are several options:</p>
<p>1-you can load a game from a csv file</p>
<p>2-you can create your own pacmans and fruits.</p>
<p>3-combine the tow options</p>
<p>After you have all the elements on the game board you can push "Run Game",after pushing you will see the path of each pacman and there movement.</p>
<p>After running ,you can save the game to csv file ,export to kml ,or clear the game board and start playing again!</p>
