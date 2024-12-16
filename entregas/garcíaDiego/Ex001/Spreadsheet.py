import string

class Spreadsheet:
    letters = list(string.ascii_uppercase) 
    columnSymbol = '|'
    rowSymbol = '     +' + '---------+' * 10


    def createCases():
        cases = []
        for i in range(15):
            cases.append(['       '] * 15)

        return cases


    def createSpreadsheet(cases,letters,userRow,userColumn, columnSymbol, rowSymbol):
        Spreadsheet.printLetters(letters, rowSymbol)

        Spreadsheet.fillCases(cases, userRow, userColumn, columnSymbol, rowSymbol)
    
    
    def printLetters(letters, rowSymbol):
        for row in range (10):
            print('       ', *letters[row] , end=' ')
        print()
        
        print(rowSymbol)


    
    def fillCases(cases, userRow, userColumn, columnSymbol, rowSymbol):
        for row in range (15):
            print(str(row+1).zfill(2), end='   ')
            for column in range (10):
                if row == userRow and column == userColumn:
                    print(columnSymbol + '['+cases[userRow][userColumn], end=']')
                else:
                    print(columnSymbol +' '+cases[row][column], end=' ')
            print(columnSymbol)
        print(rowSymbol)
        
        

    def menu(letters, cases, userRow, userColumn):
        print('Actual case: [' , letters[userColumn] + str(userRow+1),']')
        print('Use "WASD" to move the case')
        print('Use "E" to write in the case')
        print('Use "Q" to exit')
        userOption = input('Introduce an option: ').upper()
        return userOption


    def optionSet(cases, userRow, userColumn, exit):

        while exit == False:
            userElection = Spreadsheet.menu(Spreadsheet.letters, cases, userRow, userColumn)
            if userElection == 'W'and userRow > 0:
                userRow -= 1
            elif userElection == 'S'and userRow < 15 - 1:
                userRow += 1
            elif userElection == 'A' and userColumn > 0:
                userColumn -= 1
            elif userElection == 'D' and userColumn < 10 - 1:
                userColumn += 1
            elif userElection == 'E':
                cases[userRow][userColumn] = input('Introduce a value: ')
                if len(cases[userRow][userColumn]) > 7:
                    cases[userRow][userColumn] = cases[userRow][userColumn][:7]
                elif len(cases[userRow][userColumn]) < 7:
                    cases[userRow][userColumn] = cases[userRow][userColumn].ljust(7)
            elif userElection == 'Q':
                exit = True
            else:
                print('Wrong option')

            Spreadsheet.createSpreadsheet(cases,Spreadsheet.letters,userRow,userColumn, Spreadsheet.columnSymbol, Spreadsheet.rowSymbol)


    def Run():
        cases = Spreadsheet.createCases()
        exit = False
        userRow = 0
        userColumn = 0
        Spreadsheet.createSpreadsheet(cases,Spreadsheet.letters,userRow,userColumn, Spreadsheet.columnSymbol, Spreadsheet.rowSymbol)
        Spreadsheet.optionSet(cases, userRow, userColumn, exit)

Spreadsheet.Run()
