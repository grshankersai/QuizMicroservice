# QuizMicroservice
This MicroService handles ,
1. Addition of the questions.
2. generating a quiz based on the category
3. Evaluating the answers based on the responses.

#### **Request to add a question :**
curl --location 'http://localhost:8080/question/add' \
--header 'Content-Type: application/json' \
--data '{
"questionTitle": "What is the capital of Telangana?",
"option1": "Hyderabad",
"option2": "Warangal",
"option3": "Secunderabad",
"option4": "RR",
"rightAnswer": "Hyderabad",
"difficultyLevel": "Easy",
"category": "Geography"
}'

#### Request to Get all Questions:
curl --location 'http://localhost:8080/question/allQuestions'

#### Request to Create a quiz
curl --location 'http://localhost:8080/quiz/create?category=Geography&numQ=5&title=GQuiz'

#### Request to get a Quiz
curl --location 'http://localhost:8080/quiz/get/1'

#### Request to get the score
curl --location 'http://localhost:8080/quiz/submit/1' \
--header 'Content-Type: application/json' \
--data '[
{
"id": 11,
"response": "Delhi"
},
{
"id": 7,
"response": "Netherlands"
},
{
"id": 10,
"response": "Kangaroo"
},
{
"id": 1,
"response": "Paris"
},
{
"id": 12,
"response": "Hyderabad"
}
]'

