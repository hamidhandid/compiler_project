package parser;

import scanner.classes.Symbol;

public interface Lexical {
    String nextToken();
    Symbol getSymbol();
}