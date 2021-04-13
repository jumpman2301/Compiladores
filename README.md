# Compiladores
--------------------------------Tareas Realizadas--------------------------------

-> Eliminar de single-Command la primera alternativa (, el comando vacío)3

->Eliminar de single-Command estas otras alternativas:
    | "begin" Command "end"
    | "let" Declaration "in" single-Command
    | "if" Expression "then" single-Command "else" single-Command
    | "while" Expression "do" single-Command

->Añadir a single-Command lo siguiente4:
	"nothing"
	| "let" Declaration "in" Command "end"
	| "if" Expression "then" Command ("elsif" Expression "then" Command)*
		"else" Command "end"

	
	|"loop" "while" Expression "do" Command "end"
	| "loop" "until" Expression "do" Command "end"
	| "loop" "do" Command "while" Expression "end"
	| "loop" "do" Command "until" Expression "end"
	| "loop" "for" Identifier "from" Expression "to" Expression "do" Command "end"

