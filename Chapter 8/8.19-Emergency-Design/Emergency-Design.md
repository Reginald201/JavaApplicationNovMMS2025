# Exercise 8.19 — Emergency Response Class (Design)

This exercise asks for a **class design**, not a working program — a list of
attributes for a class `Emergency` that an object-oriented E9-1-1 system
might use.

## Proposed attributes for class `Emergency`

| Attribute | Type | Purpose |
|---|---|---|
| `callerName` | String | Name of the person reporting the emergency, if known |
| `callerPhoneNumber` | String | Caller's phone number, captured automatically by E9-1-1 |
| `callerAddress` | String | Physical address of the caller (wired) or derived location (wireless) |
| `latitude`, `longitude` | double | GPS coordinates for wireless calls (Phase II E9-1-1) |
| `emergencyType` | enum (`MEDICAL`, `FIRE`, `POLICE`, `OTHER`) | Nature of the emergency |
| `emergencyDescription` | String | Free-text details of the situation |
| `timeReported` | LocalDateTime | Timestamp the call was received |
| `assignedPSAP` | String | The Public Service Answering Point handling the call |
| `dispatchedResponders` | List\<String\> | Which units/agencies were sent (police, ambulance, fire) |
| `responseStatus` | enum (`REPORTED`, `DISPATCHED`, `EN_ROUTE`, `ON_SCENE`, `RESOLVED`) | Current state of the response |
| `priorityLevel` | int | Triage priority used to order dispatch |
| `callDurationSeconds` | int | How long the call lasted, for QA/analysis |

## Notes

- `callerAddress` vs. `latitude`/`longitude`: wired (landline) 9-1-1 calls
  typically resolve to a registered street address, while wireless calls
  rely on cell-site/GPS data — a real design would keep both and prefer
  whichever is available and most precise.
- `responseStatus` models the E9-1-1 workflow described in the exercise:
  the PSAP receives the call, determines the appropriate responders, and
  tracks the response through to resolution.
- This class is a natural candidate for composition: an `Emergency` object
  could hold a `Caller` object and a `Location` object rather than flat
  fields, if the system grows in complexity.

No code is required for this exercise — it's a class-design exercise, per
the textbook's "Making a Difference" section.
