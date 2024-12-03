#!/bin/bash

declare -a DUMMIES=(
    '{"author": "Hito", "genre": "Horror", "title": "Matkul PBO"}'
    '{"author": "Helmi", "genre": "Adventure", "title": "Apa yah"}'
    '{"author": "Raihan", "genre": "Romance", "title": "Apa yah"}'
    '{"author": "Bayu", "genre": "Action", "title": "Apa yah"}'
)

for (( i=0; i<${#DUMMIES[@]}; i++ ));
do
    curl -H "Content-Type: application/json" \
        -X POST \
        -d "${DUMMIES[$i]}" \
        http://localhost:3000/api/books &
done
