from constants.colors import ACTIVE_BG_COLOR, ACTIVE_FG_COLOR, RESET_COLOR
from constants.constants import CELL_WIDTH

class Cell:
    def __init__(self, content=" " * CELL_WIDTH):
        self.content = content
    
    def format_content(self, is_active):
        if is_active:
            return ACTIVE_BG_COLOR + ACTIVE_FG_COLOR + self.content.center(CELL_WIDTH) + RESET_COLOR
        return self.content.center(CELL_WIDTH)
