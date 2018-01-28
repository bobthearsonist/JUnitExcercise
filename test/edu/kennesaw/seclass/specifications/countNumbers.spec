#countNumbers
#Parameters
#none

#Environment
#String validity
String is valid:
  Null. [error] [property null]
  Empty. [error] [property empty]

#String number contents
Numbers in the string:
  No numbers. [if !null][if!empty]
  Single digit number. [if !null][if!empty]
  Multiple digit number. [if !null][if!empty]

#String number location.
Number is located:
  End of string. [single][if !null][if!empty]
  Start of string. [single][if !null][if!empty]
  Dispersed in string. [single][if !null][if!empty]

#String whitespace contents
String contains whitespace:
  Yes. [if !null][if!empty]
  No. [if !null][if!empty]
