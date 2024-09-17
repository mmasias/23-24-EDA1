from constants.constants import DIRECTIONS
from components.sheet import Sheet
from components.sheet_renderer import SheetRenderer
from components.cursor import Cursor
from components.cell_content_editor import CellContentEditor
from utils.console import Console

class MainApp:
    def __init__(self, rows, cols):
        self.sheet = Sheet(rows, cols)
        self.renderer = SheetRenderer(self.sheet)
        self.cursor = Cursor(rows, cols)
        self.running = True
    
    def run(self):
        cell_content_editor = CellContentEditor(self.sheet)
        while self.running:
            self.renderer.print_sheet(self.cursor.get_position())
            action = Console.get_user_input()

            if action == "q":
                self.running = False 
                Console.goodbye()
            elif action == "e":
                row, col = self.cursor.get_position()
                cell_content_editor.edit(row, col)
            elif action in DIRECTIONS:
                self.cursor.move(action)
            else:
                Console.print_error("Invalid action!")
                input()

