# Who, What, When?
This repository contains (in time, I hope) a mechanism for stating facts and
deriving facts based on those stated. The name of the project comes from all
facts being composed of 1 part data (what) and 2 parts metadata (who and when).

# Data - What
Assertions would be a better term to use than facts, but that is a much longer
word. Thus, I will tend to use the term fact for brevity. What is being asserted
as fact generally takes the form of a (subject verb object) triple.

## Simple facts
- (Fred was-born-in England)
- (England is-in United-Kingdom)
- (England is-in European-Union)
- (Sally is-mother-of Fred)
- (Tom is-father-of Fred)


## Facts about other facts
- ((England is-in European-Union) is-true-after 1973)
- ((England is-in European-Union) is-true-before 2020)

## Something different
There are also facts that take another form

- (X is-in Y) and (Y is-in Z) implies (X is-in Z)
- (M is-mother-of A) and (M is-mother-of B) implies (A is-sibling-of B) 

# Metadata - Who & When
In addition to what is being asserted, all facts are asserted by some one
at some time. Both of those factors will help determine if the assertion is trusted.
So, rather than being just informational, metadata will lead to different
conclusions based upon facts that apply to it.

- (I trust Mom)
- (I trust Dad)
- (I trust Fred)
- ((I trust Fred) about Botany)
- ((I trust Dad) about Things-invented-before-carbon-paper)
- ((I trust Betty) is-true-before (Betty stole all-my-money)) 

# Motivating problems

- Graphs of facts
- Traceable assertions (how do I know this?)


# Other annoying problems
- Few people have globally unique names (John James Smith)
- The name clarity/precision tradeoff problem applies to lots of things (like times and places)
- What exactly does it mean if I trust Betty before she sole all my money?
