Environments:
#string
String value:
  Null. [error]
  Empty. [error]
  Yes.

Length of string:
    0. [property zero]
    1.
    odd.
    even.
    int max. [single]

Contains whitespace:
  yes. [if !zero]
  no. [if !zero]

Parameters:
#n
n value:
  <0.[single]
  int max. [single]
  < string length. [property less] [if !zero]
  > string length. [property more]

#padded
Padded:
  true. [if less]
  false.
