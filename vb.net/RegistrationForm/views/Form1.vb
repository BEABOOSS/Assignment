Class Form1
    Private Sub Btn_submit_Click(sender As Object, e As EventArgs) Handles btn_submit.Click
        FormController.SubmitForm(
            txtb_username,
                      txtb_email,
                      txtb_pwd,
                      txtb_cPwd,
                      rb_male,
                      rb_female,
                      rb_other,
                      txtb_address,
                      cbox_State,
                      txtb_country,
                      mtxt_phoneNum)
    End Sub

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Dim db As New DbManager()
        If Not db.DoesTableExist Then
            db.CreateTable()

        End If

        For index = 1 To 14
            cbox_State.Items.Add(StateExtensions.GetDisplayName(index))
        Next
        cbox_State.SelectedIndex = 0
    End Sub



    ''' <summary>
    ''' Remove index Select State only if state is changed runs once
    ''' </summary>
    ''' <param name="sender"></param>
    ''' <param name="e"></param>
    Private Sub Cbox_State_SelectedIndexChanged(sender As Object, e As EventArgs) Handles cbox_State.SelectedIndexChanged
        If Not cbox_State.SelectedIndex = 0 AndAlso cbox_State.Items.Count = 14 Then
            cbox_State.Items.RemoveAt(0)
        End If

    End Sub



    Private Sub btn_clear_Click(sender As Object, e As EventArgs) Handles btn_clear.Click
        FormController.ClearForm(txtb_username,
                      txtb_email,
                      txtb_pwd,
                      txtb_cPwd,
                      rb_male,
                      rb_female,
                      rb_other,
                      txtb_address,
                      cbox_State,
                      txtb_country,
                      mtxt_phoneNum)
    End Sub

    'Private Sub mtxt_phoneNum_MaskInputRejected(sender As Object, e As MaskInputRejectedEventArgs) Handles mtxt_phoneNum.MaskInputRejected
    '    mtxt_phoneNum.Select(0, mtxt_phoneNum.TextLength)
    'End Sub
End Class