var n = 6;
var ar = [1,4,4,4,5,3];
MigratoryBirds(n,ar);


function MigratoryBirds(n, ar) {
    var countObject = {"1" : 0, "2" : 0, "3" : 0, "4" : 0, "5" : 0};
    ar.forEach(function(element) {
        countObject[element]++;
    });

    var answer = 0
    Object.keys(countObject).forEach(function(key) {
        var value = countObject[key];
        if (value > answer) {
            answer = key;
        }
    });
    return answer;
}
