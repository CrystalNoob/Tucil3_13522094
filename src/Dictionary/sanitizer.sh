# From one of the linux distribution flavors, I used
# scp -P 22 username@fedora:/usr/share/dict/words [Path-to-Destination]
# to get the words file

# The words file itself is from the words package sourced from the Moby Project

# This is a script to sort, sanitize (remove any numbers and symbols), and copy a
# dictionary file to the bin folder of this repository. This script shall be used
# at the root folder of the repository

sort -u src/Dictionary/words -o words.txt
rg '^[A-Za-z]+$' words.txt > words_alphabet.txt
mv words_alphabet.txt bin/words.txt
rm words.txt

# rg version used:
# ripgrep 14.1.0 (rev e50df40a19)
