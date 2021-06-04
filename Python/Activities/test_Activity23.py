import pytest

def test_sumOfNumbers(initializeList):
    sum = 0
    for number in initializeList:
        sum = sum + number
    assert sum==55