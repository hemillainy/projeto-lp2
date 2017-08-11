#!/bin/bash

login="cassioegc"
senha="casedugc11"
read -p "Comentário: " comentario

function enviar() {
	git add .
	git commit -m $comentario
}
enviar
