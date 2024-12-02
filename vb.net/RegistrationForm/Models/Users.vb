Public Class Users
    'Properties
    Private _user_ID As Integer
    Private _username As String
    Private _email As String
    Private _password As String
    Private _gender As GenderType
    Private _address As String
    Private _state As StatesType
    Private _country As String
    Private _phoneNumber As String

    'Constructor
    Public Sub New()

    End Sub

    'creating new users
    Public Sub New(
                   name As String,
                   email As String,
                   password As String,
                   gender As Integer,
                   address As String,
                   state As Integer,
                   country As String,
                   phoneNumber As String)
        Me._username = name
        Me._email = email
        Me._password = password
        Me._gender = gender
        Me._address = address
        Me._state = state
        Me._country = country
        Me._phoneNumber = phoneNumber

    End Sub

    'getting a user 
    Public Sub New(
                   id As Integer,
                   name As String,
                   email As String,
                   password As String,
                   gender As Integer,
                   address As String,
                   state As Integer,
                   country As String,
                   phoneNumber As String)
        Me._user_ID = id
        Me._username = name
        Me._email = email
        Me._password = password
        Me._gender = gender
        Me._address = address
        Me._state = state
        Me._country = country
        Me._phoneNumber = phoneNumber

    End Sub

    'Get/Set
    Public Property Id As Integer
        Get
            Return _user_ID
        End Get
        Set(value As Integer)
            _user_ID = value
        End Set
    End Property

    Public Property Username As String
        Get
            Return _username
        End Get
        Set(value As String)
            _username = value
        End Set
    End Property

    Public Property Email As String
        Get
            Return _email
        End Get
        Set(value As String)
            _email = value
        End Set
    End Property

    Public Property Password As String
        Get
            Return _password
        End Get
        Set(value As String)
            _password = value
        End Set
    End Property

    Public Property GenderGS As Integer
        Get
            Return _gender
        End Get
        Set(value As Integer)
            _gender = value
        End Set
    End Property

    Public Property Address As String
        Get
            Return _address
        End Get
        Set(value As String)
            _address = value
        End Set
    End Property

    Public Property State As Integer
        Get
            Return _state
        End Get
        Set(value As Integer)
            If value = StatesType.SELECT_STATE Then
                _state = StatesType.UNSPECIFIED
            End If
            _state = value
        End Set
    End Property

    Public Property Country As String
        Get
            Return _country
        End Get
        Set(value As String)
            _country = value
        End Set
    End Property

    Public Property PhoneNumber As String
        Get
            Return _phoneNumber
        End Get
        Set(value As String)
            _phoneNumber = value
        End Set
    End Property

End Class

