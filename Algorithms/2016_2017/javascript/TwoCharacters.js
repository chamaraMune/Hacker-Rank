function twoCharaters(input) {
    var distinctCharacters = [];
    for (var idx = 0; idx < input.length; idx++ ) {
        let letter = input[idx];

        if (distinctCharacters.indexOf(letter) == -1) {
            distinctCharacters.push(letter);
        }
    }

    var characterSets = [];

    for (let idx1 = 0; idx1 < distinctCharacters.length - 1; idx1++) {
        for (let idx2 = idx1 + 1; idx2 < distinctCharacters.length; idx2++) {
            let characterSet = [distinctCharacters[idx1], distinctCharacters[idx2]];
            characterSets.push(characterSet);
        }
    }
    var possibleAnswers = [];

    for(let characterSet of characterSets) {
        var count = 0;
        let firstLetter = characterSet[0];
        let secondLetter = characterSet[1];
        let startIdx = (input.indexOf(firstLetter) < input.indexOf(secondLetter)) ? input.indexOf(firstLetter) : input.indexOf(secondLetter);
        var tempString = '';

        for (let idx = startIdx; idx < input.length; idx++) {
            if (input[idx] == firstLetter || input[idx] == secondLetter) {
                tempString = tempString.concat(input[idx]);
            }
        }
        possibleAnswers.push(tempString)
    }

    var answer = 0;
    for (let possibleAnswer of possibleAnswers) {
        let isValidString = true;

        for (let idx = 0; idx < possibleAnswer.length - 1; idx++) {

            if (possibleAnswer[idx] == possibleAnswer[idx + 1]) {
                isValidString = false;
                break;
            }
        }

        if (isValidString && possibleAnswer.length > answer) {
            answer = possibleAnswer.length;
        }
    }
    return answer;
}
