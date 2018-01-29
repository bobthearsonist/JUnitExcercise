Environment:
#String
String value:
  null. [error]
  #For this empty case I feel like there will be a lot of unhandled exception so I did not constrain the other inputs relative to it]
  empty. [property empty]
  #I made this a single simply to constrain the domain. Technically for full coverage you would want to test it with others.
  int max. [single]

Number of numbers in the string:
  None.
  1.
  2.
  #I fell like if we can find two we can find more
  #you would want to test a really long string to try to overflow internal counters but that string would be tedious to generate.

Parameters:
startPosition
  <1.
  1.
  >1.

endPosition
  <start.
  =start.
  >start.
