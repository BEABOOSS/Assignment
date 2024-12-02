Public Class UserController
    Private ReadOnly userDAO As DbManager

    Public Sub New()
        Me.userDAO = New DbManager()
    End Sub

    Public Sub CreateUser(
                                username As String,
                                email As String,
                                pwd As String,
                                gender As Integer,
                                address As String,
                                state As Integer,
                                country As String,
                                phoneNum As String)
        Dim user As New Users(username, email, pwd, gender, address, state, country, phoneNum)
        Dim wantToSave As String = String.Format("Would you like to save this information?%nName: %s%nEmail: %s%nPassword: %s%nGender: %s%nAddress: %s%nState: %s%nCountry: %s%nPhone Number: %s%n",
                user.Username(),
                user.Email(),
                user.Password(),
                GenderExension.GetDisplayName(user.GenderGS()),
                user.Address(),
                StateExtensions.GetDisplayName(user.State()),
                user.Country(),
                user.PhoneNumber())
        Dim res As DialogResult = MessageBox.Show(wantToSave, "Want To Save?", MessageBoxButtons.OKCancel, MessageBoxIcon.Question, MessageBoxDefaultButton.Button2)

        If res.Yes Then
            userDAO.AddUser(user)
        End If


    End Sub


End Class
