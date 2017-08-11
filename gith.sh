#!/bin/bash

read -p "Comentário: " comentario

function enviar() {
	git add .
	git commit -m $comentario
	git push origin dudu
}
enviar
