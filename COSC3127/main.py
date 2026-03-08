# Andrew Mansur

import sys

# Token codes
class Token:
    PROGRAM = 'PROGRAM'
    BEGIN = 'BEGIN'
    END = 'END'
    IF = 'IF'
    THEN = 'THEN'
    LOOP = 'LOOP'
    IDENTIFIER = 'IDENTIFIER'
    INT_CONSTANT = 'INT_CONSTANT'
    ASSIGN = 'ASSIGN'         # =
    PLUS = 'PLUS'             # +
    MINUS = 'MINUS'           # -
    MULTIPLY = 'MULTIPLY'     # *
    DIVIDE = 'DIVIDE'         # /
    LESS_THAN = 'LESS_THAN'   # <
    GREATER_THAN = 'GREATER_THAN'  # >
    LPAREN = 'LPAREN'         # (
    RPAREN = 'RPAREN'         # )
    SEMICOLON = 'SEMICOLON'   # ;
    EOF = 'EOF'
    UNKNOWN = 'UNKNOWN'

# keywords mapping
KEYWORDS = {
    'program': Token.PROGRAM,
    'begin': Token.BEGIN,
    'end': Token.END,
    'if': Token.IF,
    'then': Token.THEN,
    'loop': Token.LOOP
}

# Lexical analyzer tokenizes input source code
class LexicalAnalyzer:
    def __init__(self, source_code):
        self.source = source_code
        self.pos = 0
        self.current_char = self.source[0] if self.source else None
        self.current_lexeme = None
        self.current_token = None

    # Move to the next char in source code
    def advance(self):

        self.pos += 1
        if self.pos < len(self.source):
            self.current_char = self.source[self.pos]
        else:
            self.current_char = None

    # Skip whitespace characters
    def skip_whitespace(self):

        while self.current_char is not None and self.current_char.isspace():
            self.advance()



    #Read an identifier or keyword
    def read_identifier(self):
        result = ''

        while self.current_char is not None and (self.current_char.isalnum() or self.current_char == '_'):

            result += self.current_char
            self.advance()
        return result

    # read an integer constant
    def read_integer(self):
        result = ''
        while self.current_char is not None and self.current_char.isdigit():
            result += self.current_char
            self.advance()
        return result


    # Returns a tuple of lexeme, token_code
    def get_next_token(self):
        while self.current_char is not None:

            # Skip whitespace
            if self.current_char.isspace():
                self.skip_whitespace()
                continue

            # Identifier or keyword (starts with letter)
            if self.current_char.isalpha():
                lexeme = self.read_identifier()

                # check if it's a keyword
                if lexeme.lower() in KEYWORDS:
                    token = KEYWORDS[lexeme.lower()]
                else:
                    token = Token.IDENTIFIER
                self.current_lexeme = lexeme
                self.current_token = token
                return (lexeme, token)

            # Integer constant
            if self.current_char.isdigit():
                lexeme = self.read_integer()
                self.current_lexeme = lexeme
                self.current_token = Token.INT_CONSTANT
                return (lexeme, Token.INT_CONSTANT)

            # Single character tokens
            if self.current_char == '=':
                self.advance()
                self.current_lexeme = '='
                self.current_token = Token.ASSIGN
                return ('=', Token.ASSIGN)

            if self.current_char == '+':
                self.advance()
                self.current_lexeme = '+'
                self.current_token = Token.PLUS
                return ('+', Token.PLUS)

            if self.current_char == '-':
                self.advance()
                self.current_lexeme = '-'
                self.current_token = Token.MINUS
                return ('-', Token.MINUS)

            if self.current_char == '*':
                self.advance()
                self.current_lexeme = '*'
                self.current_token = Token.MULTIPLY
                return ('*', Token.MULTIPLY)

            if self.current_char == '/':
                self.advance()
                self.current_lexeme = '/'
                self.current_token = Token.DIVIDE
                return ('/', Token.DIVIDE)

            if self.current_char == '<':
                self.advance()
                self.current_lexeme = '<'
                self.current_token = Token.LESS_THAN
                return ('<', Token.LESS_THAN)

            if self.current_char == '>':
                self.advance()
                self.current_lexeme = '>'
                self.current_token = Token.GREATER_THAN
                return ('>', Token.GREATER_THAN)

            if self.current_char == '(':
                self.advance()
                self.current_lexeme = '('
                self.current_token = Token.LPAREN
                return ('(', Token.LPAREN)

            if self.current_char == ')':
                self.advance()
                self.current_lexeme = ')'
                self.current_token = Token.RPAREN
                return (')', Token.RPAREN)

            if self.current_char == ';':
                self.advance()
                self.current_lexeme = ';'
                self.current_token = Token.SEMICOLON
                return (';', Token.SEMICOLON)

            # Unknown character
            char = self.current_char
            self.advance()
            self.current_lexeme = char
            self.current_token = Token.UNKNOWN


            return (char, Token.UNKNOWN)

        # End of file
        self.current_lexeme = 'EOF'
        self.current_token = Token.EOF

        return ('EOF', Token.EOF)


# recursive descent parser based on the EBNF grammar
class Parser:

    def __init__(self, lexer):
        self.lexer = lexer
        self.current_lexeme = None
        self.current_token = None
        self.advance()  


    # Get the next token from the lexer
    def advance(self):
        self.current_lexeme, self.current_token = self.lexer.get_next_token()

    # Match the current token with the expected token
    def match(self, expected_token):
        if self.current_token == expected_token:
            self.advance()
            return True
        return False


    # main parsing method
    def parse(self):
        try:
            self.program()
            if self.current_token == Token.EOF:
                return True
            else:
                return False
        except SyntaxError:
            return False

    # <program> -> program begin <statement_list> end
    def program(self):
        if not self.match(Token.PROGRAM):
            raise SyntaxError("Expected 'program'")

        if not self.match(Token.BEGIN):
            raise SyntaxError("Expected 'begin'")

        self.statement_list()

        if not self.match(Token.END):

            raise SyntaxError("Expected 'end'")
        

    # <statement_list> -> <statement> {;<statement>}
    def statement_list(self):
        self.statement()

        while self.current_token == Token.SEMICOLON:

            self.advance()  # consume semicolon
            self.statement()

    # <statement> -> <assignment_statement> | <if_statement> | <loop_statement>
    def statement(self):

        if self.current_token == Token.IF:
            self.if_statement()
        elif self.current_token == Token.LOOP:
            self.loop_statement()
        elif self.current_token == Token.IDENTIFIER:
            self.assignment_statement()
        else:
            raise SyntaxError("Expected statement")

    # <assignment_statement> -> <variable> = <expression>
    def assignment_statement(self):
        self.variable()

        if not self.match(Token.ASSIGN):
            raise SyntaxError("Expected '='")

        self.expression()

    # <variable> -> identifier
    def variable(self):

        if not self.match(Token.IDENTIFIER):
            raise SyntaxError("Expected identifier")

    # <expression> -> <term> { (+|-) <term>}
    def expression(self):
        self.term()

        while self.current_token in (Token.PLUS, Token.MINUS):
            self.advance()  # consume operator
            self.term()


    # <term> -> <factor> {(* | /) <factor>}
    def term(self):
        self.factor()

        while self.current_token in (Token.MULTIPLY, Token.DIVIDE):

            self.advance()  # consume operator
            self.factor()




    # <factor> -> identifier | int_constant | (<expression>)
    def factor(self):

        if self.current_token == Token.IDENTIFIER:
            self.advance()
        elif self.current_token == Token.INT_CONSTANT:
            self.advance()
        elif self.current_token == Token.LPAREN:
            self.advance()  # consume '('
            self.expression()
            if not self.match(Token.RPAREN):
                raise SyntaxError("Expected ')'")
        else:
            raise SyntaxError("Expected identifier, integer, or '('")

    # <if_statement> -> if (<logic_expression>) then <statement>
    def if_statement(self):
        if not self.match(Token.IF):
            raise SyntaxError("Expected 'if'")

        if not self.match(Token.LPAREN):
            raise SyntaxError("Expected '('")

        self.logic_expression()

        if not self.match(Token.RPAREN):

            raise SyntaxError("Expected ')'")

        if not self.match(Token.THEN):
            raise SyntaxError("Expected 'then'")

        self.statement()

    # <logic_expression> -> <variable> (< | >) <variable>
    def logic_expression(self):
        self.variable()

        if self.current_token == Token.LESS_THAN:
            self.advance()
        elif self.current_token == Token.GREATER_THAN:
            self.advance()
        else:
            raise SyntaxError("Expected '<' or '>'")

        self.variable()

    # <loop_statement> -> loop (<logic_expression>) <statement>
    def loop_statement(self):

        if not self.match(Token.LOOP):

            raise SyntaxError("Expected 'loop'")

        if not self.match(Token.LPAREN):
            raise SyntaxError("Expected '('")

        self.logic_expression()

        if not self.match(Token.RPAREN):

            raise SyntaxError("Expected ')'")

        self.statement()


# read a file 

def analyze_file(filename):
    try:
        with open(filename, 'r') as file:
            source_code = file.read()

    except FileNotFoundError:

        print(f"Error: File '{filename}' not found.")
        return
    
    except IOError as e:

        print(f"Error reading file: {e}")
        return

    print("=" * 60)
    print("INPUT PROGRAM:")
    print("=" * 60)
    print(source_code)
    print("=" * 60)

    # create lexical analyzer and parser
    lexer = LexicalAnalyzer(source_code)
    parser = Parser(lexer)

    # parse and output result
    if parser.parse():

        print("RESULT: The program is syntactically correct.")
    else:
        print("RESULT: The program contains syntax error(s).")


    print("=" * 60)
    print()


def main():
    if len(sys.argv) < 2:
        print("Usage: python main.py <input_file>")
        print("\nNo input file provided. Running all test files...\n")

        # Run all test files
        for i in range(1, 7):

            test_file = f"test{i}.txt"
            print(f"\n{'#' * 60}")
            print(f"TEST PROGRAM {i}")
            print(f"{'#' * 60}")
            analyze_file(test_file)

    else:
        filename = sys.argv[1]
        analyze_file(filename)


if __name__ == "__main__":
    main()
