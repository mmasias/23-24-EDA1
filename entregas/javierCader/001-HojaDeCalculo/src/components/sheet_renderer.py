from constants.colors import HEADER_COLOR, RESET_COLOR
from constants.constants import CELL_WIDTH
from utils.console import Console

class SheetRenderer:
    def __init__(self, sheet):
        self.sheet = sheet

    def _print_separator(self):
        print("┌" + "┬".join(["─" * CELL_WIDTH for _ in range(len(self.sheet.get_cols()))]) + "┐")

    def _print_headers(self):
        headers = [HEADER_COLOR + chr(65 + col).center(CELL_WIDTH) + RESET_COLOR for col in range(len(self.sheet.get_cols()))]
        print("│" + "│".join(headers) + "│")

    def _print_row_separator(self):
        print("├" + "┼".join(["─" * CELL_WIDTH for _ in range(len(self.sheet.get_cols()))]) + "┤")

    def _print_footer(self):
        print("└" + "┴".join(["─" * CELL_WIDTH for _ in range(len(self.sheet.get_cols()))]) + "┘")
        print()
        
    def _print_sheet_headers(self):
        Console.clear()
        print(HEADER_COLOR + "Python Excel App v1.1 By Javier Cáder".center(CELL_WIDTH * len(self.sheet.get_cols()) + 11) + RESET_COLOR)
        self._print_separator()
        self._print_headers()
        self._print_row_separator()

    def print_sheet(self, current_pos):
        self._print_sheet_headers()

        for i, row in enumerate(self.sheet.get_rows()):
            self._print_row(row, i, current_pos)
            if i != len(self.sheet.get_rows()) - 1:
                self._print_row_separator()
                
        self._print_footer()

    def _print_row(self, row, row_idx, current_pos):
        row_data = [cell.format_content((row_idx, j) == current_pos) for j, cell in enumerate(row)]
        print("│" + "│".join(row_data) + "│")
