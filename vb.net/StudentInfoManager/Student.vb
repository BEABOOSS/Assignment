Public Class Student
    Private _student_ID As Integer
    Private Shared _next_ID As Integer = 1000
    Private _firstName As String
    Private _lastName As String
    Private _age As Integer
    Private _program As String
    Private _teacher As String

    Public Sub New(firstName As String, lastName As String, age As Integer, program As String, teacher As String)
        Me._student_ID = _next_ID
        _next_ID += 1
        Me._firstName = firstName
        Me._lastName = lastName
        Me._age = age
        Me._program = program
        Me._teacher = teacher
    End Sub

    Public Function GetStudentID() As Integer
        Return _student_ID
    End Function

    Public Property FirstName As String

        Get
            Return _firstName
        End Get
        Set(value As String)
            _firstName = value
        End Set

    End Property

    Public Property LastName As String

        Get
            Return _lastName
        End Get
        Set(value As String)
            _lastName = value
        End Set

    End Property

    Public Property Age As Integer

        Get
            Return _age
        End Get
        Set(value As Integer)
            _age = value
        End Set

    End Property

    Public Property Program As String

        Get
            Return _program
        End Get
        Set(value As String)
            _program = value
        End Set

    End Property

    Public Property Teacher As String

        Get
            Return _teacher
        End Get
        Set(value As String)
            _teacher = value
        End Set

    End Property

End Class
