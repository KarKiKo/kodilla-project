call runcrud
echo Press a key when server is up
timeout 25
start "" http://localhost:8080/crud/v1/task/getTasks
echo Work is finished


