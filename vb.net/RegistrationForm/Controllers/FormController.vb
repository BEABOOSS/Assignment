Public Class FormController

    Public Shared Sub SubmitForm(
                                username As TextBox,
                                email As TextBox,
                                pwd As TextBox,
                                cPwd As TextBox,
                                male As RadioButton,
                                female As RadioButton,
                                other As RadioButton,
                                address As TextBox,
                                state As ComboBox,
                                country As TextBox,
                                phoneNum As MaskedTextBox)
        Try
            Dim userController As New UserController()
            userController.CreateUser(
                FormValidator.UsernameValidator(username),
                FormValidator.EmailValidation(email),
                FormValidator.PasswordValidation(pwd, cPwd),
                FormValidator.GetSelectedGender(male, female, other),
                FormValidator.AddressValidator(address),
                FormValidator.GetSelectedState(state),
                FormValidator.CountryValidation(country),
                FormValidator.PhoneNumberValidation(phoneNum))
        Catch ex As ArgumentException
            MsgBox(ex.Message, MsgBoxStyle.Critical, "Form Validation Error")
        End Try

    End Sub


    Public Shared Sub ClearForm(
                                username As TextBox,
                                email As TextBox,
                                pwd As TextBox,
                                cPwd As TextBox,
                                male As RadioButton,
                                female As RadioButton,
                                other As RadioButton,
                                address As TextBox,
                                state As ComboBox,
                                country As TextBox,
                                phoneNum As MaskedTextBox)
        username.Text = ""
        email.Text = ""
        pwd.Text = ""
        cPwd.Text = ""
        male.Checked = False
        female.Checked = False
        other.Checked = False
        address.Text = ""
        If Not state.Items.Count = 14 Then
            state.Items.Insert(0, StateExtensions.GetDisplayName(StatesType.SELECT_STATE))
            state.SelectedIndex = 0
        End If
        country.Text = ""
        phoneNum.Text = ""

    End Sub

End Class
