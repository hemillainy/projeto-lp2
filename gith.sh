#!/bin/bash

read -p "Comentário: " comentario
read -p "Branch: " branch

function enviar() {
	git add .
	git commit -m $comentario
	git push origin $branch
}

enviar

