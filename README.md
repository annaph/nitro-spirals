# Spirals technical task
Solution for a Spirals technical task.  
Refer to _Description.pdf_ for details on required functionalities.

### Usage

#### Compile
```sh
$ sbt
> compile
```

#### Run unit tests
```sh
$ sbt
> test
```

#### Run
```sh
$ sbt
> runMain com.nitro.spirals.SpiralsApp <input_number>
```

e.g., for input number _12_:
```sh
$ sbt
> runMain com.nitro.spirals.SpiralsApp 12
```

Output should look like:
```sh
[info] Location(value = 12, row = -1, column = 2)
[info] ===> Distance for '12' is: 3
```

### Brief description
Solution is using an algorithm that treats numbers as elements grouped into spiral levels. Each level contains following information:
+ __value__  
Level identifier. Incrementally increases by 1 starting from 0 (_0, 1, 2, ..._).
+ __numberOfElements__  
The total number of elements in the level
+ __firstLocation__  
The location of the first element in the level
+ __lastLocation__  
The location of the last element in the level
+ __numberOfElementsPerQuadrant__  
Number of elements per level quadrant

First level has value 0 and only one element with location:  
`Location(value = 1, row = 0, column = 0)`  

Level _0_ and Element _1_ represent the center of the spiral.
The next level, with value _1_, contains elements that are located in the next spiral:

`Location(value = 2, row = 0, column = 1)`  
`Location(value = 3, row = -1, column = 1)`  
`Location(value = 4, row = -1, column = 0)`  
`Location(value = 5, row = -1, column = -1)`  
`Location(value = 6, row = 0, column = -1)`  
`Location(value = 7, row = 1, column = -1)`  
`Location(value = 8, row = 1, column = 0)`  
`Location(value = 9, row = 1, column = 1)`  

For every subsequent spiral, the level value gets increased by _1_. Last element in the level always has a location:

`Location(value = <some_value>, row = <level_value>, column = <level_value>)`

Elements inside a level are organised into 4 quadrants:
+ __Right__  
column is equal to _level value_
+ __Top__  
row is equal to _-1 x level value_
+ __Left__  
column is equal to _-1 x level value_
+ __Bottom__  
row is equal to _level value_

On startup algorithm builds an infinite, lazy stream where each element in the stream represents a level, starting from Level _0_. See `com.nitro.spirals.allLevels` for implementation details.

For given input number algorithm performs following steps:
- Find the level to which the number belongs
- Find inside the level the quadrant to which the number belongs
- Find the exact location inside the quadrant

The distance from the center is equal to:  
`abs(location.row) + abs(location.column)`
