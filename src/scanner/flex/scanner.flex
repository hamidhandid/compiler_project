package scanner.classes;

%%

%class CompilerScanner
%public
%unicode
//%standalone
%line
%column
%function nextSymbol
%type Symbol

%{
    public Symbol currentSymbol;
    public int intValue = 0;
    public float realValue = 0.0f;
    public boolean booleanValue;
    public StringBuffer string  = new StringBuffer();
    private Symbol symbol(String token, Type type) {
        return new Symbol(token, type);
    }
%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace = {LineTerminator} | [ \t\f]

// Comment
TraditionalComment = "/*" [^*] ~"*/" | "/*"~"*/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?
Comment = {TraditionalComment} | {EndOfLineComment}

// Identifiers
Digit = [0-9]
ZeroOrMoreDigits = {Digit}*
OneOrMoreDigits = {Digit}+
Letter = [a-zA-Z]
Underline = "_"
Identifier = {Letter} ({Underline} | {Letter} | {Digit}) {0, 30}

// Numbers
Sign = [+-]?
DecimalInteger = {Sign}{OneOrMoreDigits}
Zero = "0"
Dot = "."
HexaDeciamlDigit = {Digit} | [a-fA-F]
OneOrMoreHexaDecimalDigit = {HexaDeciamlDigit}+
Xx = "x" | "X"
Ee = "e" | "E"
HexaDecimal = {Sign} {Zero} {Xx} {OneOrMoreHexaDecimalDigit}
RealNumber = {Sign} {OneOrMoreDigits} {Dot} {ZeroOrMoreDigits}
ScientificNotation = ({RealNumber} | {DecimalInteger}) {Ee} {DecimalInteger}

// Reserved Keywords
Void = "void"
Int = "int"
Double = "double"
Function = "function"
Bool = "bool"
String = "string"
Record = "record"
For = "for"
While = "while"
If = "if"
Else = "else"
Return = "return"
Break = "break"
New = "New"
Array = "Array"
Print = "Print"
ReadInteger = "ReadInteger"
ReadLine = "ReadLine"
ReadReal = "ReadReal"
Continue = "continue"
False = "false"
True = "true"
ReservedKeyword = {Function} | {Void} | {Int} | {Double} | {Bool} | {String} | {Record} | {For} | {While} | {If} | {Else} | {Return} | {Break} | {New} | {Array} | {Print} | {ReadInteger} | {ReadLine} | {ReadReal} | {Continue} | {False} | {True}

// Operators and Punctuations
Add = "+"
Unaryminus = "-"
Production = "*"
Division = "/"
Percent = "%"
AdditionAssignment = "+="
SubtractionAssignment = "-="
ProductionAssignment = "*="
DivisionAssignment = "/="
Increment = "++"
Decrement = "--"
Less = "<"
LessEqual = "<="
Greater = ">"
GreaterEqual = ">="
NotEqual = "!="
Equal = "=="
Assignment = "="
Mod = "%"
LogicalAnd = "&&"
LogicalOr = "||"
BitwiseAnd = "&"
BitwiseOr = "|"
StringLiteral = "“"
BitwiseXor = "^"
Not = "!"
Dot = "."
Comma = ","
Colon = ":"
Semicolon = ";"
OpeningBraces = "["
ClosingBraces = "]"
OpeningParenthesis = "("
ClosingParenthesis = ")"
OpeningCurlyBraces = "{"
ClosingCurlyBraces = "}"
OperatorAndPunctuation = {Percent} | {Add} | {Unaryminus} | {Production} | {Division} | {AdditionAssignment} | {SubtractionAssignment} | {ProductionAssignment} | {DivisionAssignment} | {Increment} | {Decrement} | {Less} | {LessEqual} | {Greater} | {GreaterEqual} | {NotEqual} | {Equal} | {Assignment} | {Mod} | {LogicalAnd} | {LogicalOr} | {BitwiseAnd} | {BitwiseOr} | {StringLiteral} | {BitwiseXor} | {Not} | {Dot} | {Comma} | {Colon} | {Semicolon} | {OpeningBraces} | {ClosingBraces} | {OpeningParenthesis} | {ClosingParenthesis} | {OpeningCurlyBraces} | {ClosingCurlyBraces}

// Boolean
Boolean = {True} | {False}

// String
StringLiteral = \"

// States
%state STRING

%%

<YYINITIAL> {
    {StringLiteral} {
         yybegin(STRING);
         return symbol(string.toString(), Type.STRING);
    }
    {Comment} {
        return symbol(yytext(), Type.COMMENT);
    }
    {Boolean} {
        booleanValue = Boolean.valueOf(yytext());
        intValue = booleanValue ? 1 : 0;
        return symbol(yytext(), Type.INTEGER_NUMBER);
    }
    {ReservedKeyword} {
        return symbol(yytext(), Type.RESERVED_KEYWORD);
    }
    {OperatorAndPunctuation} {
        return symbol(yytext(), Type.OPERATOR_AND_PUNCTUATION);
    }
    {Identifier} {
        return symbol(yytext(), Type.IDENTIFIER);
    }
    {DecimalInteger} {
        intValue = Integer.valueOf(yytext());
        return symbol(yytext(), Type.INTEGER_NUMBER);
    }
    {RealNumber} {
        realValue = Float.valueOf(yytext() + "f");
        return symbol(yytext(), Type.REAL_NUMBER);
    }
    {HexaDecimal} {
        String absoluteStringValue = yytext().substring(yytext().indexOf("0") + 2);
        char firstChar = yytext().charAt(0);
        String stringToParse = (firstChar == '-') ? firstChar + absoluteStringValue : absoluteStringValue;
        intValue = Integer.parseInt(stringToParse, 16);
        return symbol(yytext(), Type.HEX);
    }
    {ScientificNotation} {
        realValue = Float.valueOf(yytext() + "f");
        return symbol(yytext(), Type.SCIENTIFIC_NOTATION);
    }
    {WhiteSpace} {
        return symbol(yytext(), Type.WHITESPACE);
    }
    [^] {
        System.err.println("\nscanner undefined token error: Token " + yytext() + " is not defined at "+ "line " + (yyline + 1) + " with character index " + yycolumn + "\n");
        return symbol(yytext(), Type.UNDEFINED);
    }
}

<STRING> {
    \"            {
                        yybegin(YYINITIAL);
                        string.append(yytext());
                        String value = string.toString();
                        System.out.println(value);
                        string = new StringBuffer();
                        return symbol(value, Type.STRING);
                    }
    [^\r\n\t\"\'\\]+  {string.append(yytext()); return symbol(yytext(), Type.STRING);}
    "\\r"   {string.append("\r"); return symbol(yytext(), Type.ESCAPE_CHAR);}
    "\\n"    {string.append("\n"); return symbol(yytext(), Type.ESCAPE_CHAR);}
    "\\t"    {string.append("\t"); return symbol(yytext(), Type.ESCAPE_CHAR);}
    "\\\'"  {string.append("'"); return symbol(yytext(), Type.ESCAPE_CHAR);}
    "\\\""  {string.append("\""); return symbol(yytext(), Type.ESCAPE_CHAR);}
    "\\\\"    {string.append("\\"); return symbol(yytext(), Type.ESCAPE_CHAR);}
}

[^] {
        System.err.println("\nscanner undefined token error: Token " + yytext() + " is not defined at "+ "line " + (yyline + 1) + " with character index " + yycolumn + "\n");
        return symbol(yytext(), Type.UNDEFINED);
}
