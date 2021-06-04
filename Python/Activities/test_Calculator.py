import pytest
import math

def test_sum():
    num1 = 10
    num2 = 30
    assert num1+num2==40

def test_multiply():
    num1 = 10
    num2 = 30
    assert num1*num2==300

@pytest.mark.activity
def test_division():
    num1 = 10
    num2 = 30
    assert num2/num1==3

@pytest.mark.activity
def test_subtract():
    num1 = 10
    num2 = 30
    assert num2-num1==40
