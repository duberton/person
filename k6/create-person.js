import http from 'k6/http';

let person = JSON.stringify({
    name: "Eduardo Berton",
    type: "NATURAL",
    document: {
        number: uuidVersion4()
    }
});

function uuidVersion4() {
  return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
    var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
    return v.toString(16);
  });
}

export default function () {
    http.post('http://localhost:7000/v1/person', person);
}