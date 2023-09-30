package seminarThree.model.excersize;

import seminarThree.model.exceptions.ExcersizeFactoryException;

public interface IExcersizeFactory {
    public BaseExcersize create(String excersizeInfo) throws ExcersizeFactoryException;
}
