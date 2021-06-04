import pytest

@pytest.fixture
def initializeList():
    numbers = list(range(11))
    return numbers