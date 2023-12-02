package subway.view.validator;

import java.util.List;

import static subway.util.message.ExceptionMessage.INPUT_MESSAGE;

public class MenuValidator extends Validator{
    public static String validate(final String input, final List<String> candidateKeys){
        validateBlank(input);
        return validateString(input, candidateKeys);
    }

    private static String validateString(final String input, final List<String> candidateKeys){
        if(!candidateKeys.contains(input)){
            throw new IllegalArgumentException(String.format(INPUT_MESSAGE.getValue(), "제시한 사항들 중에 입력해주세요."));
        }
        return input;
    }
}
