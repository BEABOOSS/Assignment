<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()>
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()>
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()>
    Private Sub InitializeComponent()
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Form1))
        Me.spc_main_Vert = New System.Windows.Forms.SplitContainer()
        Me.Title = New System.Windows.Forms.Label()
        Me.spc_inputs = New System.Windows.Forms.SplitContainer()
        Me.TableLayout = New System.Windows.Forms.TableLayoutPanel()
        Me.mtxt_phoneNum = New System.Windows.Forms.MaskedTextBox()
        Me.txtb_email = New System.Windows.Forms.TextBox()
        Me.lbl_phoneNum = New System.Windows.Forms.Label()
        Me.lbl_country = New System.Windows.Forms.Label()
        Me.lbl_state = New System.Windows.Forms.Label()
        Me.lbl_address = New System.Windows.Forms.Label()
        Me.lbl_gender = New System.Windows.Forms.Label()
        Me.lbl_cPwd = New System.Windows.Forms.Label()
        Me.lbl_pwd = New System.Windows.Forms.Label()
        Me.lbl_email = New System.Windows.Forms.Label()
        Me.lbl_username = New System.Windows.Forms.Label()
        Me.txtb_pwd = New System.Windows.Forms.TextBox()
        Me.txtb_cPwd = New System.Windows.Forms.TextBox()
        Me.txtb_country = New System.Windows.Forms.TextBox()
        Me.txtb_address = New System.Windows.Forms.TextBox()
        Me.cbox_State = New System.Windows.Forms.ComboBox()
        Me.radio_btn_gr = New System.Windows.Forms.FlowLayoutPanel()
        Me.rb_male = New System.Windows.Forms.RadioButton()
        Me.rb_female = New System.Windows.Forms.RadioButton()
        Me.rb_other = New System.Windows.Forms.RadioButton()
        Me.txtb_username = New System.Windows.Forms.TextBox()
        Me.btn_clear = New System.Windows.Forms.Button()
        Me.btn_submit = New System.Windows.Forms.Button()
        CType(Me.spc_main_Vert, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.spc_main_Vert.Panel1.SuspendLayout()
        Me.spc_main_Vert.Panel2.SuspendLayout()
        Me.spc_main_Vert.SuspendLayout()
        CType(Me.spc_inputs, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.spc_inputs.Panel1.SuspendLayout()
        Me.spc_inputs.Panel2.SuspendLayout()
        Me.spc_inputs.SuspendLayout()
        Me.TableLayout.SuspendLayout()
        Me.radio_btn_gr.SuspendLayout()
        Me.SuspendLayout()
        '
        'spc_main_Vert
        '
        Me.spc_main_Vert.Dock = System.Windows.Forms.DockStyle.Fill
        Me.spc_main_Vert.FixedPanel = System.Windows.Forms.FixedPanel.Panel1
        Me.spc_main_Vert.IsSplitterFixed = True
        Me.spc_main_Vert.Location = New System.Drawing.Point(0, 0)
        Me.spc_main_Vert.Name = "spc_main_Vert"
        Me.spc_main_Vert.Orientation = System.Windows.Forms.Orientation.Horizontal
        '
        'spc_main_Vert.Panel1
        '
        Me.spc_main_Vert.Panel1.Controls.Add(Me.Title)
        '
        'spc_main_Vert.Panel2
        '
        Me.spc_main_Vert.Panel2.Controls.Add(Me.spc_inputs)
        Me.spc_main_Vert.Size = New System.Drawing.Size(450, 450)
        Me.spc_main_Vert.SplitterDistance = 84
        Me.spc_main_Vert.TabIndex = 0
        '
        'Title
        '
        Me.Title.AutoSize = True
        Me.Title.Font = New System.Drawing.Font("Microsoft Sans Serif", 20.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Title.ForeColor = System.Drawing.SystemColors.HotTrack
        Me.Title.Location = New System.Drawing.Point(12, 39)
        Me.Title.Name = "Title"
        Me.Title.Size = New System.Drawing.Size(328, 31)
        Me.Title.TabIndex = 15
        Me.Title.Text = "New Account Registration"
        '
        'spc_inputs
        '
        Me.spc_inputs.Dock = System.Windows.Forms.DockStyle.Fill
        Me.spc_inputs.IsSplitterFixed = True
        Me.spc_inputs.Location = New System.Drawing.Point(0, 0)
        Me.spc_inputs.Name = "spc_inputs"
        Me.spc_inputs.Orientation = System.Windows.Forms.Orientation.Horizontal
        '
        'spc_inputs.Panel1
        '
        Me.spc_inputs.Panel1.Controls.Add(Me.TableLayout)
        '
        'spc_inputs.Panel2
        '
        Me.spc_inputs.Panel2.Controls.Add(Me.btn_clear)
        Me.spc_inputs.Panel2.Controls.Add(Me.btn_submit)
        Me.spc_inputs.Size = New System.Drawing.Size(450, 362)
        Me.spc_inputs.SplitterDistance = 292
        Me.spc_inputs.TabIndex = 0
        '
        'TableLayout
        '
        Me.TableLayout.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink
        Me.TableLayout.ColumnCount = 2
        Me.TableLayout.ColumnStyles.Add(New System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 37.3259!))
        Me.TableLayout.ColumnStyles.Add(New System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 62.6741!))
        Me.TableLayout.Controls.Add(Me.mtxt_phoneNum, 1, 8)
        Me.TableLayout.Controls.Add(Me.txtb_email, 1, 1)
        Me.TableLayout.Controls.Add(Me.lbl_phoneNum, 0, 8)
        Me.TableLayout.Controls.Add(Me.lbl_country, 0, 7)
        Me.TableLayout.Controls.Add(Me.lbl_state, 0, 6)
        Me.TableLayout.Controls.Add(Me.lbl_address, 0, 5)
        Me.TableLayout.Controls.Add(Me.lbl_gender, 0, 4)
        Me.TableLayout.Controls.Add(Me.lbl_cPwd, 0, 3)
        Me.TableLayout.Controls.Add(Me.lbl_pwd, 0, 2)
        Me.TableLayout.Controls.Add(Me.lbl_email, 0, 1)
        Me.TableLayout.Controls.Add(Me.lbl_username, 0, 0)
        Me.TableLayout.Controls.Add(Me.txtb_pwd, 1, 2)
        Me.TableLayout.Controls.Add(Me.txtb_cPwd, 1, 3)
        Me.TableLayout.Controls.Add(Me.txtb_country, 1, 7)
        Me.TableLayout.Controls.Add(Me.txtb_address, 1, 5)
        Me.TableLayout.Controls.Add(Me.cbox_State, 1, 6)
        Me.TableLayout.Controls.Add(Me.radio_btn_gr, 1, 4)
        Me.TableLayout.Controls.Add(Me.txtb_username, 1, 0)
        Me.TableLayout.Location = New System.Drawing.Point(3, 3)
        Me.TableLayout.Name = "TableLayout"
        Me.TableLayout.Padding = New System.Windows.Forms.Padding(30, 0, 0, 0)
        Me.TableLayout.RowCount = 9
        Me.TableLayout.RowStyles.Add(New System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 32.0!))
        Me.TableLayout.RowStyles.Add(New System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 32.0!))
        Me.TableLayout.RowStyles.Add(New System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 32.0!))
        Me.TableLayout.RowStyles.Add(New System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 32.0!))
        Me.TableLayout.RowStyles.Add(New System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 32.0!))
        Me.TableLayout.RowStyles.Add(New System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 32.0!))
        Me.TableLayout.RowStyles.Add(New System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 32.0!))
        Me.TableLayout.RowStyles.Add(New System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 32.0!))
        Me.TableLayout.RowStyles.Add(New System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Absolute, 32.0!))
        Me.TableLayout.Size = New System.Drawing.Size(372, 288)
        Me.TableLayout.TabIndex = 0
        '
        'mtxt_phoneNum
        '
        Me.mtxt_phoneNum.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle
        Me.mtxt_phoneNum.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.mtxt_phoneNum.Location = New System.Drawing.Point(160, 259)
        Me.mtxt_phoneNum.Mask = "999 000 0000"
        Me.mtxt_phoneNum.Name = "mtxt_phoneNum"
        Me.mtxt_phoneNum.PromptChar = Global.Microsoft.VisualBasic.ChrW(32)
        Me.mtxt_phoneNum.Size = New System.Drawing.Size(165, 24)
        Me.mtxt_phoneNum.TabIndex = 11
        '
        'txtb_email
        '
        Me.txtb_email.BackColor = System.Drawing.SystemColors.InactiveCaption
        Me.txtb_email.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle
        Me.txtb_email.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtb_email.Location = New System.Drawing.Point(160, 35)
        Me.txtb_email.Name = "txtb_email"
        Me.txtb_email.Size = New System.Drawing.Size(165, 24)
        Me.txtb_email.TabIndex = 2
        '
        'lbl_phoneNum
        '
        Me.lbl_phoneNum.AutoSize = True
        Me.lbl_phoneNum.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lbl_phoneNum.Location = New System.Drawing.Point(33, 256)
        Me.lbl_phoneNum.Name = "lbl_phoneNum"
        Me.lbl_phoneNum.Size = New System.Drawing.Size(100, 16)
        Me.lbl_phoneNum.TabIndex = 16
        Me.lbl_phoneNum.Text = "Phone Number:"
        '
        'lbl_country
        '
        Me.lbl_country.AutoSize = True
        Me.lbl_country.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lbl_country.Location = New System.Drawing.Point(33, 224)
        Me.lbl_country.Name = "lbl_country"
        Me.lbl_country.Size = New System.Drawing.Size(55, 16)
        Me.lbl_country.TabIndex = 15
        Me.lbl_country.Text = "Country:"
        '
        'lbl_state
        '
        Me.lbl_state.AutoSize = True
        Me.lbl_state.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lbl_state.Location = New System.Drawing.Point(33, 192)
        Me.lbl_state.Name = "lbl_state"
        Me.lbl_state.Size = New System.Drawing.Size(41, 16)
        Me.lbl_state.TabIndex = 13
        Me.lbl_state.Text = "State:"
        '
        'lbl_address
        '
        Me.lbl_address.AutoSize = True
        Me.lbl_address.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lbl_address.Location = New System.Drawing.Point(33, 160)
        Me.lbl_address.Name = "lbl_address"
        Me.lbl_address.Size = New System.Drawing.Size(61, 16)
        Me.lbl_address.TabIndex = 12
        Me.lbl_address.Text = "Address:"
        '
        'lbl_gender
        '
        Me.lbl_gender.AutoSize = True
        Me.lbl_gender.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lbl_gender.Location = New System.Drawing.Point(33, 128)
        Me.lbl_gender.Name = "lbl_gender"
        Me.lbl_gender.Size = New System.Drawing.Size(55, 16)
        Me.lbl_gender.TabIndex = 10
        Me.lbl_gender.Text = "Gender:"
        '
        'lbl_cPwd
        '
        Me.lbl_cPwd.AutoSize = True
        Me.lbl_cPwd.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lbl_cPwd.Location = New System.Drawing.Point(33, 96)
        Me.lbl_cPwd.Name = "lbl_cPwd"
        Me.lbl_cPwd.Size = New System.Drawing.Size(118, 16)
        Me.lbl_cPwd.TabIndex = 9
        Me.lbl_cPwd.Text = "Confirm Password:"
        '
        'lbl_pwd
        '
        Me.lbl_pwd.AutoSize = True
        Me.lbl_pwd.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lbl_pwd.Location = New System.Drawing.Point(33, 64)
        Me.lbl_pwd.Name = "lbl_pwd"
        Me.lbl_pwd.Size = New System.Drawing.Size(113, 16)
        Me.lbl_pwd.TabIndex = 8
        Me.lbl_pwd.Text = "Create Password:"
        '
        'lbl_email
        '
        Me.lbl_email.AutoSize = True
        Me.lbl_email.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lbl_email.Location = New System.Drawing.Point(33, 32)
        Me.lbl_email.Name = "lbl_email"
        Me.lbl_email.Size = New System.Drawing.Size(98, 16)
        Me.lbl_email.TabIndex = 7
        Me.lbl_email.Text = "Email Address:"
        '
        'lbl_username
        '
        Me.lbl_username.AutoSize = True
        Me.lbl_username.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lbl_username.Location = New System.Drawing.Point(33, 3)
        Me.lbl_username.Margin = New System.Windows.Forms.Padding(3, 3, 3, 0)
        Me.lbl_username.Name = "lbl_username"
        Me.lbl_username.Size = New System.Drawing.Size(47, 16)
        Me.lbl_username.TabIndex = 17
        Me.lbl_username.Text = "Name:"
        '
        'txtb_pwd
        '
        Me.txtb_pwd.BackColor = System.Drawing.SystemColors.InactiveCaption
        Me.txtb_pwd.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle
        Me.txtb_pwd.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtb_pwd.Location = New System.Drawing.Point(160, 67)
        Me.txtb_pwd.Name = "txtb_pwd"
        Me.txtb_pwd.Size = New System.Drawing.Size(165, 24)
        Me.txtb_pwd.TabIndex = 3
        '
        'txtb_cPwd
        '
        Me.txtb_cPwd.BackColor = System.Drawing.SystemColors.InactiveCaption
        Me.txtb_cPwd.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle
        Me.txtb_cPwd.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtb_cPwd.Location = New System.Drawing.Point(160, 99)
        Me.txtb_cPwd.Name = "txtb_cPwd"
        Me.txtb_cPwd.Size = New System.Drawing.Size(165, 24)
        Me.txtb_cPwd.TabIndex = 4
        '
        'txtb_country
        '
        Me.txtb_country.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle
        Me.txtb_country.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtb_country.Location = New System.Drawing.Point(160, 227)
        Me.txtb_country.Name = "txtb_country"
        Me.txtb_country.Size = New System.Drawing.Size(165, 24)
        Me.txtb_country.TabIndex = 10
        '
        'txtb_address
        '
        Me.txtb_address.BackColor = System.Drawing.SystemColors.Window
        Me.txtb_address.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle
        Me.txtb_address.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtb_address.Location = New System.Drawing.Point(160, 163)
        Me.txtb_address.Name = "txtb_address"
        Me.txtb_address.Size = New System.Drawing.Size(165, 24)
        Me.txtb_address.TabIndex = 8
        '
        'cbox_State
        '
        Me.cbox_State.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.cbox_State.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.cbox_State.FormattingEnabled = True
        Me.cbox_State.Location = New System.Drawing.Point(160, 195)
        Me.cbox_State.Name = "cbox_State"
        Me.cbox_State.Size = New System.Drawing.Size(165, 26)
        Me.cbox_State.TabIndex = 9
        '
        'radio_btn_gr
        '
        Me.radio_btn_gr.Controls.Add(Me.rb_male)
        Me.radio_btn_gr.Controls.Add(Me.rb_female)
        Me.radio_btn_gr.Controls.Add(Me.rb_other)
        Me.radio_btn_gr.Location = New System.Drawing.Point(160, 131)
        Me.radio_btn_gr.Name = "radio_btn_gr"
        Me.radio_btn_gr.Size = New System.Drawing.Size(209, 26)
        Me.radio_btn_gr.TabIndex = 21
        '
        'rb_male
        '
        Me.rb_male.AutoSize = True
        Me.rb_male.FlatAppearance.BorderSize = 0
        Me.rb_male.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.rb_male.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.rb_male.Location = New System.Drawing.Point(3, 3)
        Me.rb_male.Name = "rb_male"
        Me.rb_male.Size = New System.Drawing.Size(54, 20)
        Me.rb_male.TabIndex = 5
        Me.rb_male.TabStop = True
        Me.rb_male.Text = "Male"
        Me.rb_male.UseVisualStyleBackColor = True
        '
        'rb_female
        '
        Me.rb_female.AutoSize = True
        Me.rb_female.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.rb_female.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.rb_female.Location = New System.Drawing.Point(63, 3)
        Me.rb_female.Name = "rb_female"
        Me.rb_female.Size = New System.Drawing.Size(70, 20)
        Me.rb_female.TabIndex = 6
        Me.rb_female.TabStop = True
        Me.rb_female.Text = "Female"
        Me.rb_female.UseVisualStyleBackColor = True
        '
        'rb_other
        '
        Me.rb_other.AutoSize = True
        Me.rb_other.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.rb_other.Font = New System.Drawing.Font("Microsoft Sans Serif", 9.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.rb_other.Location = New System.Drawing.Point(139, 3)
        Me.rb_other.Name = "rb_other"
        Me.rb_other.Size = New System.Drawing.Size(56, 20)
        Me.rb_other.TabIndex = 7
        Me.rb_other.TabStop = True
        Me.rb_other.Text = "Other"
        Me.rb_other.UseVisualStyleBackColor = True
        '
        'txtb_username
        '
        Me.txtb_username.BackColor = System.Drawing.SystemColors.InactiveCaption
        Me.txtb_username.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle
        Me.txtb_username.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtb_username.Location = New System.Drawing.Point(160, 3)
        Me.txtb_username.Name = "txtb_username"
        Me.txtb_username.Size = New System.Drawing.Size(165, 24)
        Me.txtb_username.TabIndex = 1
        '
        'btn_clear
        '
        Me.btn_clear.FlatAppearance.BorderColor = System.Drawing.SystemColors.ActiveBorder
        Me.btn_clear.FlatAppearance.MouseDownBackColor = System.Drawing.SystemColors.ButtonFace
        Me.btn_clear.FlatAppearance.MouseOverBackColor = System.Drawing.SystemColors.ButtonHighlight
        Me.btn_clear.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.btn_clear.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_clear.Location = New System.Drawing.Point(160, 3)
        Me.btn_clear.Name = "btn_clear"
        Me.btn_clear.Size = New System.Drawing.Size(75, 32)
        Me.btn_clear.TabIndex = 13
        Me.btn_clear.Text = "Clear"
        Me.btn_clear.UseVisualStyleBackColor = True
        '
        'btn_submit
        '
        Me.btn_submit.FlatAppearance.BorderColor = System.Drawing.SystemColors.ActiveBorder
        Me.btn_submit.FlatAppearance.MouseDownBackColor = System.Drawing.SystemColors.ButtonFace
        Me.btn_submit.FlatAppearance.MouseOverBackColor = System.Drawing.SystemColors.ButtonHighlight
        Me.btn_submit.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.btn_submit.Font = New System.Drawing.Font("Microsoft Sans Serif", 11.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_submit.Location = New System.Drawing.Point(79, 3)
        Me.btn_submit.Name = "btn_submit"
        Me.btn_submit.Size = New System.Drawing.Size(75, 32)
        Me.btn_submit.TabIndex = 12
        Me.btn_submit.Text = "Submit"
        Me.btn_submit.UseVisualStyleBackColor = True
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(450, 450)
        Me.Controls.Add(Me.spc_main_Vert)
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle
        Me.Icon = CType(resources.GetObject("$this.Icon"), System.Drawing.Icon)
        Me.Name = "Form1"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Registration Form"
        Me.spc_main_Vert.Panel1.ResumeLayout(False)
        Me.spc_main_Vert.Panel1.PerformLayout()
        Me.spc_main_Vert.Panel2.ResumeLayout(False)
        CType(Me.spc_main_Vert, System.ComponentModel.ISupportInitialize).EndInit()
        Me.spc_main_Vert.ResumeLayout(False)
        Me.spc_inputs.Panel1.ResumeLayout(False)
        Me.spc_inputs.Panel2.ResumeLayout(False)
        CType(Me.spc_inputs, System.ComponentModel.ISupportInitialize).EndInit()
        Me.spc_inputs.ResumeLayout(False)
        Me.TableLayout.ResumeLayout(False)
        Me.TableLayout.PerformLayout()
        Me.radio_btn_gr.ResumeLayout(False)
        Me.radio_btn_gr.PerformLayout()
        Me.ResumeLayout(False)

    End Sub

    Friend WithEvents spc_main_Vert As SplitContainer
    Friend WithEvents spc_inputs As SplitContainer
    Friend WithEvents Title As Label
    Friend WithEvents TableLayout As TableLayoutPanel
    Friend WithEvents lbl_username As Label
    Friend WithEvents txtb_username As TextBox
    Friend WithEvents lbl_phoneNum As Label
    Friend WithEvents lbl_country As Label
    Friend WithEvents lbl_state As Label
    Friend WithEvents lbl_address As Label
    Friend WithEvents lbl_gender As Label
    Friend WithEvents lbl_cPwd As Label
    Friend WithEvents lbl_pwd As Label
    Friend WithEvents lbl_email As Label
    Friend WithEvents txtb_pwd As TextBox
    Friend WithEvents txtb_cPwd As TextBox
    Friend WithEvents txtb_country As TextBox
    Friend WithEvents txtb_address As TextBox
    Friend WithEvents cbox_State As ComboBox
    Friend WithEvents radio_btn_gr As FlowLayoutPanel
    Friend WithEvents rb_male As RadioButton
    Friend WithEvents rb_female As RadioButton
    Friend WithEvents rb_other As RadioButton
    Friend WithEvents txtb_email As TextBox
    Friend WithEvents btn_clear As Button
    Friend WithEvents btn_submit As Button
    Friend WithEvents mtxt_phoneNum As MaskedTextBox
End Class
