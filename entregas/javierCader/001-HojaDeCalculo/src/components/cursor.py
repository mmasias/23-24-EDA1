from constants.constants import DIRECTIONS

class Cursor:
    def __init__(self, max_rows, max_cols):
        self.current_pos = (0, 0)
        self.max_rows = max_rows
        self.max_cols = max_cols

    def move(self, direction):
        dx, dy = DIRECTIONS.get(direction, (0, 0))
        x, y = self.current_pos
        x = max(0, min(x + dx, self.max_rows - 1))
        y = max(0, min(y + dy, self.max_cols - 1))
        self.current_pos = (x, y)
        return self.current_pos

    def get_position(self):
        return self.current_pos
