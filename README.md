# Compiladores
--------------------------------Tareas Realizadas--------------------------------

->Eliminar de single-Command estas otras alternativas:
    | "begin" Command "end"
    | "let" Declaration "in" single-Command
    | "if" Expression "then" single-Command "else" single-Command
    | "while" Expression "do" single-Command

->Añadir a single-Command lo siguiente4:
	"nothing"
	| "let" Declaration "in" Command "end"
	
	|"loop" "while" Expression "do" Command "end"
