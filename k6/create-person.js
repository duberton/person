import http from 'k6/http';

let person = JSON.stringify({
    name: "Eduardo Berton",
    type: "NATURAL",
    document: {
        number: "123"
    }
});

export default function () {
    http.post('http://localhost:7000/v1/person', person);
}