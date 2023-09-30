package seminarThree.model.excersize;

import seminarThree.model.exceptions.ExcersizeFactoryException;

public class ExcersizeFactory implements IExcersizeFactory {
    @Override
    public BaseExcersize create(String excersizeInfo) throws ExcersizeFactoryException {
        String[] info = excersizeInfo.split(" ");
        if (info.length != 3) {
            throw new ExcersizeFactoryException("string parameter != 3");
        }

        if (!info[2].matches("\\d+")) {
            throw new ExcersizeFactoryException("number is not correct");
        }

        switch (info[1]) {
            case "repeat":
                return new RepetitionExcersize(info[0], Integer.parseInt(info[2]));
            case "time":
                return new TimeExcersize(info[0], Integer.parseInt(info[2]));
            default:
                throw new ExcersizeFactoryException("can not define excersize type");
        }
    }
}
