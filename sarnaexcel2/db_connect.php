<?php



class DB_Connect {

    private $conn;
    public function connect() {
        require_once 'config.php';
        $this->conn = mysqli_connect(hostname, user, password, db_name)
        or die("Could not connect to db");

        return $this->conn;


    }



}

?>