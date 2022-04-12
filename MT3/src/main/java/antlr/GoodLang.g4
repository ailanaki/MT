grammar GoodLang;

NAME : ([a-z]|[A-Z])+[0-9]*;
FUN_NAME_START: ([a-z]|[A-Z])+[0-9]*'(';
WS : [ \t\r\n]+ -> skip;
NUMBER : [1-9]*[0-9]+('.'[0-9]+)*;
SIGN_1: '*'|'/';
SIGN_2: '+'|'-';
BKT_1: '(';
BKT_2: ')';
COMPARASON: '>' | '<' | '==' | '!=' | '<=' |'>=';

r  : prog* EOF;
prog: assume | expr | operatorIf;
expr:
       fun
    |   expr SIGN_1 expr
    |	expr SIGN_2 expr
    |	NUMBER | NAME
    |	BKT_1 expr BKT_2
    ;

fun :  FUN_NAME_START ((expr ',')* expr  ')'| ')');
start_assume: NAME (',' NAME)*;
end_assume: '='  expr (',' expr)*;
assume: start_assume end_assume;
logic: expr (COMPARASON expr)*;
logExpr: (fun | logic);
operatorIf: start_if enter_if;
start_if: 'if (' logExpr ')';
enter_if: '{'(WS* prog*)'}';