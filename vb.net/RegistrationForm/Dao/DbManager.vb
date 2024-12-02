Imports MySql.Data.MySqlClient

Public Class DbManager
    Private Property connectingString = "server=localhost;user id=root;password=;database=registration"
    Private Property connect As MySqlConnection
    Private Shared ReadOnly TABLE_NAME = "users"

    'Constructor
    Public Sub New()
        Try
            Me.connect = New MySqlConnection(connectingString)

        Catch ex As Exception
            MsgBox(ex.Message, MsgBoxStyle.Critical, "Connection Failed")
        End Try
    End Sub



    Public Sub AddUser(user As Users)
        Dim cmd As New MySqlCommand

        Try
            Me.connect.Open()
            cmd.Connection = Me.connect
            cmd.CommandText = "INSERT INTO " & TABLE_NAME & "VALUES(default, @username, @email, @password, @gender, @address, @state, @country, @phoneNumber)"

            cmd.Parameters.AddWithValue("@username", user.Username)
            cmd.Parameters.AddWithValue("@email", user.Email)
            cmd.Parameters.AddWithValue("@password", user.Password)
            cmd.Parameters.AddWithValue("@gender", user.GenderGS)
            cmd.Parameters.AddWithValue("@address", user.Address)
            cmd.Parameters.AddWithValue("@state", user.State)
            cmd.Parameters.AddWithValue("@country", user.Country)
            cmd.Parameters.AddWithValue("@phoneNumber", user.PhoneNumber)

            Dim rowAffected = cmd.ExecuteNonQuery
            MsgBox("Row Affected: " & rowAffected)


        Catch ex As Exception
            MsgBox(ex.Message, MsgBoxStyle.Critical, "Add User Failed")
        Finally
            Me.connect.Close()
        End Try

    End Sub



    Public Sub CreateTable()
        Dim sqlQuery As String = "CREATE TABLE " & TABLE_NAME &
            " (user_ID INTEGER PRIMARY KEY AUTO_INCREMENT," &
            " username VARCHAR(255)," &
            " email VARCHAR(255)," &
            " password VARCHAR(255)," &
            " gender INTEGER," &
            " address VARCHAR(255)," &
            " state INTEGER," &
            " country VARCHAR(255)," &
            " phoneNumber VARCHAR(12)" &
            ");"

        Try
            Me.connect.Open()
            Dim cmd As New MySqlCommand(sqlQuery, Me.connect)

            cmd.ExecuteNonQuery()
        Catch ex As Exception
            MessageBox.Show(ex.Message, "OOPS...", MessageBoxButtons.OK, MessageBoxIcon.Error)
        End Try
    End Sub


    Public Function DoesTableExist() As Boolean
        Dim query As String = "SELECT * FROM " & TABLE_NAME

        Try
            Me.connect.Open()
            Dim cmd As New MySqlCommand(query, Me.connect)

            cmd.ExecuteNonQuery()
            Return True
        Catch ex As Exception
            Return False
        Finally
            Me.connect.Close()
        End Try
    End Function


End Class
