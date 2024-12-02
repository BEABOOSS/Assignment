Public Enum StatesType
    UNSPECIFIED = 0
    SELECT_STATE = 1
    ALBERTA = 2
    BRITISH_COLUMBIA = 3
    MANITOBA = 4
    NEW_BRUNSWICK = 5
    NEWFOUNDLAND_AND_LABRADOR = 6
    NOVA_SCOTIA = 7
    ONTARIO = 8
    PRINCE_EDWARD_ISLAND = 9
    QUEBEC = 10
    SASKATCHEWAN = 11
    YUKON = 12
    NUNAVUT = 13
    NORTHWEST_TERRITORIES = 14
End Enum

Public Class StateExtensions
    Private Shared ReadOnly DisplayNames As New Dictionary(Of Integer, String) From {
        {0, "Unspecified"},
        {1, "Select State"},
        {2, "Alberta"},
        {3, "British Columbia"},
        {4, "Manitoba"},
        {5, "New Brunswick"},
        {6, "Newfoundland and Labrador"},
        {7, "Nova Scotia"},
        {8, "Ontario"},
        {9, "Prince Edward Island"},
        {10, "Quebec"},
        {11, "Saskatchewan"},
        {12, "Yukon"},
        {13, "Nunavut"},
        {14, "Northwest Territories"}
        }
    Public Shared Function GetDisplayName(state As Integer) As String

        For Each keyValuePair As KeyValuePair(Of Integer, String) In DisplayNames
            If state = keyValuePair.Key Then
                Return keyValuePair.Value
            End If
        Next

        Return DisplayNames.Item(1)
    End Function

End Class