package org.example;

class NegativeAmountException extends Exception
{
    public NegativeAmountException(String message)
    {
        super(message);
    }
}