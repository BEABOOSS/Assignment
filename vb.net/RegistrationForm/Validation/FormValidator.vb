Imports System.Text.RegularExpressions

Public Class FormValidator
    Private Shared ReadOnly MAX_LENGTH As Integer = 254
    Private Shared ReadOnly NOT_SPECIFIED = "N/A"


    Public Shared Function UsernameValidator(input As TextBox) As String
        Dim name = input.Text()
        Dim pattern As String = "[A-Za-z]+"
        Dim regex As New Regex(pattern)

        If String.IsNullOrWhiteSpace(name) Then
            Throw New ArgumentException("Name cannot be empty")
        End If

        If Not regex.IsMatch(name) Then
            Throw New ArgumentException("Invalid Name")
        End If

        If name.Length() > MAX_LENGTH Then
            Throw New ArgumentException($"Name exceeds maximum length of {MAX_LENGTH} characters")
        End If

        Return name.Trim()

    End Function

    Public Shared Function EmailValidation(input As TextBox) As String
        Dim email = input.Text()
        Dim pattern As String = "^[^@\s]+@[^@\s]+\.[^@\s]+$"
        Dim regex As New Regex(pattern)


        If String.IsNullOrWhiteSpace(email) Then
            Throw New ArgumentException("Email address cannot be empty")
        End If

        If Not regex.IsMatch(email) Then
            Throw New ArgumentException("Invalid email address format")
        End If

        If email.Length > MAX_LENGTH Then
            Throw New ArgumentException($"Email address exceeds maximum length of {MAX_LENGTH} characters")
        End If

        Return email.Trim()

    End Function

    Public Shared Function PasswordValidation(inputA As TextBox, inputB As TextBox) As String
        Dim pwd As String = inputA.Text()
        Dim cPwd As String = inputB.Text()
        Dim MIN_LENGTH As Integer = 5


        If String.IsNullOrWhiteSpace(pwd) Or String.IsNullOrWhiteSpace(cPwd) Then
            Throw New ArgumentException("Fields password or confirm password is empty")
        End If

        If pwd.Length < MIN_LENGTH Then
            Throw New ArgumentException("Please enter a longer password.")
        End If

        If Not pwd.Equals(cPwd) Then
            Throw New ArgumentException("Fields password or confirm password do not match. Please ensure that you enter the same password in both fields")
        End If

        Return pwd

    End Function

    ''' <summary>
    ''' Return an integer
    ''' </summary>
    ''' <param name="rb_a">Male</param>
    ''' <param name="rb_b">Female</param>
    ''' <param name="rb_c">Other</param>
    ''' <returns></returns>
    Public Shared Function GetSelectedGender(rb_a As RadioButton, rb_b As RadioButton, rb_c As RadioButton) As Integer

        If rb_a.Checked Then
            Return GenderType.Male
        End If

        If rb_b.Checked Then
            Return GenderType.Female
        End If
        If rb_c.Checked Then
            Return GenderType.Other
        End If

        Return GenderType.Unsepecified


    End Function


    Public Shared Function AddressValidator(input As TextBox) As String

        If String.IsNullOrWhiteSpace(input.Text) Then
            Return NOT_SPECIFIED
        End If

        If input.TextLength() > MAX_LENGTH Then
            Throw New ArgumentException($"Address exceeds maximum length of {MAX_LENGTH} characters")
        End If

        Return input.Text().Trim()

    End Function

    Public Shared Function GetSelectedState(input As ComboBox) As Integer

        Dim selectedIndex = input.SelectedIndex

        If selectedIndex = StatesType.SELECT_STATE Then
            Return StatesType.UNSPECIFIED
        End If

        Return selectedIndex

    End Function

    Public Shared Function CountryValidation(input As TextBox) As String
        Dim country As String = input.Text()
        Dim pattern As String = "[A-Za-z]+"
        Dim regex As New Regex(pattern)

        If String.IsNullOrWhiteSpace(country) Then
            Return NOT_SPECIFIED
        End If

        If Not regex.IsMatch(country) Then
            Throw New ArgumentException("Invalid Country Format")
        End If

        If country.Length() > MAX_LENGTH Then
            Throw New ArgumentException($"Country exceeds maximum length of {MAX_LENGTH} characters")
        End If

        Return country.Trim()
    End Function

    Public Shared Function PhoneNumberValidation(input As MaskedTextBox) As String

        If String.IsNullOrWhiteSpace(input.Text) Then
            Return NOT_SPECIFIED
        End If
        Const MAX_CHAR = 12
        If Not input.TextLength = MAX_CHAR Then
            Throw New ArgumentException("Enter your full phone number")
        End If

        Return input.Text.Trim()
    End Function

End Class
