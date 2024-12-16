import string


class Main:
    
    def __init__(self):
        self.spreadsheet = Spreadsheet()
        self.view = View()
    
    def run(self):
        self.view.show(self.spreadsheet)
        
        while not self.spreadsheet.exit:
            print('Actual case: [' , View.letters[self.spreadsheet.user_column] + str(self.spreadsheet.user_row + 1),']')
            print('Use "WASD" to move the case')
            print('Use "E" to write in the case')
            print('Use "Q" to exit')
            user_option = input('Introduce an option: ').upper()
            
            if user_option in 'WASD':
                self.spreadsheet.move(user_option)
            elif user_option == 'E':
                value = input('Introduce a value: ')
                self.spreadsheet.edit(value)
            elif user_option == 'Q':
                self.spreadsheet.should_exit(user_option)
            else:
                print('Wrong option')
            
            self.view.show(self.spreadsheet)



class Spreadsheet:
    def __init__(self, rows=15, columns=10):
        self.rows = rows
        self.columns = columns
        self.cases = [['       '] * columns for _ in range(rows)]
        self.user_row = 0
        self.user_column = 0
        self.exit = False
    
    def move(self, direction):
        if direction == 'W' and self.user_row > 0:
            self.user_row -= 1
        elif direction == 'S' and self.user_row < self.rows - 1:
            self.user_row += 1
        elif direction == 'A' and self.user_column > 0:
            self.user_column -= 1
        elif direction == 'D' and self.user_column < self.columns - 1:
            self.user_column += 1
    
    def edit(self, value):
        self.cases[self.user_row][self.user_column] = value.ljust(7)[:7]
    
    def should_exit(self, option):
        self.exit = option == 'Q'



class View:
    letters = list(string.ascii_uppercase)
    
    def show(self, spreadsheet):
        column_symbol = '|'
        row_symbol = '     +' + '---------+' * spreadsheet.columns

        for row in range (spreadsheet.columns):
            print('       ', *View.letters[row] , end=' ')
        print()
        
        print(row_symbol)
        
        for row in range(spreadsheet.rows):
            print(str(row+1).zfill(2), end='   ')
            for column in range(spreadsheet.columns):
                cell = '[' + spreadsheet.cases[row][column] + ']' if row == spreadsheet.user_row and column == spreadsheet.user_column else ' ' + spreadsheet.cases[row][column] + ' '
                print(column_symbol + cell, end='')
            print(column_symbol)
        
        print(row_symbol)

if __name__ == "__main__":
    main = Main()
    main.run()
