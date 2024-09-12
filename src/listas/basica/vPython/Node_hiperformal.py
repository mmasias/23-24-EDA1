class Node:
    def __init__(self, value):
        self.__value = value
        self.__next = None

    @property
    def value(self):
        return self.value

    @value.setter
    def value(self, new_value):
        self.__value = new_value

    @property
    def next(self):
        return self.__next

    @next.setter
    def next(self, next_node):
        self.__next = next_node
