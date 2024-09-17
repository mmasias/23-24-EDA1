from utils.console import Console
from constants.constants import CELL_WIDTH

class CellContentEditor:
    def __init__(self, sheet):
        self.sheet = sheet

    def edit(self, row, col):
        content = Console.get_cell_content_input()
        validated_content = self._validate_content(content)
        self.sheet.get_cell(row, col).content = validated_content

    def _validate_content(self, content):
        if len(content) > CELL_WIDTH:
            print("Content is too long. Truncating...")
            return content[:CELL_WIDTH]
        return content
